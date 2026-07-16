package com.pasteleria.backend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pasteleria.backend.dto.AuthResponse;
import com.pasteleria.backend.dto.LoginRequest;
import com.pasteleria.backend.dto.RegisterRequest;
import com.pasteleria.backend.model.Rol;
import com.pasteleria.backend.model.Usuario;
import com.pasteleria.backend.repository.UsuarioRepository;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public AuthService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtService jwtService) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }



    public void registrar(RegisterRequest request) {

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El correo ya está registrado");
        }


        // Los registros públicos siempre serán usuarios normales
        Usuario usuario = new Usuario(
                request.getNombre(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                Rol.USER
        );


        usuarioRepository.save(usuario);
    }




    public AuthResponse login(LoginRequest request) {


        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );



        String token = jwtService.generarToken(authentication);



        String rol =
                authentication.getAuthorities()
                .iterator()
                .next()
                .getAuthority();



        return new AuthResponse(
                token,
                "Bearer",
                authentication.getName(),
                rol
        );
    }

}