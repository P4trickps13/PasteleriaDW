package com.pasteleria.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.StandardCharsets;
import java.util.List;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    private final String jwtSecret =
            "EsteEsUnSecretoLocalSoloParaDesarrolloPasteleria1234567890";



    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .cors(Customizer.withDefaults())

            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            )


            .authorizeHttpRequests(auth -> auth


                // Rutas públicas
                .requestMatchers(
                    "/auth/**",
                    "/publico/**",
                    "/h2-console/**"
                )
                .permitAll()



                // Catálogo público
                .requestMatchers(
                    HttpMethod.GET,
                    "/api/productos/**",
                    "/api/hero-slides/**",
                    "/api/gallery-items/**",
                    "/api/benefits/**",
                    "/api/business-hours/**",
                    "/api/testimonials/**"
                )
                .permitAll()



                // Acciones clientes
                .requestMatchers(
                    HttpMethod.POST,
                    "/api/pedidos",
                    "/api/encargos",
                    "/api/newsletter"
                )
                .permitAll()



                // Administración
                .requestMatchers(
                    "/admin/**",
                    "/api/productos/**",
                    "/api/pedidos/**",
                    "/api/clientes/**"
                )
                .hasAuthority("ADMIN")



                .anyRequest()
                .authenticated()
            )



            .oauth2ResourceServer(oauth2 ->
                oauth2.jwt(jwt ->
                    jwt.jwtAuthenticationConverter(
                        jwtAuthenticationConverter()
                    )
                )
            )



            .headers(headers ->
                headers.frameOptions(frame ->
                    frame.disable()
                )
            );


        return http.build();
    }




    @Bean
    CorsConfigurationSource corsConfigurationSource() {


        CorsConfiguration configuration =
                new CorsConfiguration();



        configuration.setAllowedOrigins(
            List.of(
                "http://localhost:5173",
                "http://localhost:3000",
                "https://pasteleria-dw.vercel.app"
            )
        );



        configuration.setAllowedMethods(
            List.of(
                "GET",
                "POST",
                "PUT",
                "PATCH",
                "DELETE",
                "OPTIONS"
            )
        );



        configuration.setAllowedHeaders(
            List.of(
                "Authorization",
                "Content-Type",
                "Accept"
            )
        );



        configuration.setAllowCredentials(true);


        configuration.setMaxAge(3600L);



        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();



        source.registerCorsConfiguration(
            "/**",
            configuration
        );



        return source;
    }





    @Bean
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }





    @Bean
    AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {


        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(
                    userDetailsService
                );


        provider.setPasswordEncoder(passwordEncoder);


        return new ProviderManager(provider);

    }





    @Bean
    JwtEncoder jwtEncoder() {


        return new NimbusJwtEncoder(
            new ImmutableSecret<>(
                jwtSecret.getBytes(StandardCharsets.UTF_8)
            )
        );

    }





    @Bean
    JwtDecoder jwtDecoder() {


        SecretKey key =
            new SecretKeySpec(
                jwtSecret.getBytes(StandardCharsets.UTF_8),
                "HmacSHA256"
            );


        return NimbusJwtDecoder
                .withSecretKey(key)
                .macAlgorithm(MacAlgorithm.HS256)
                .build();

    }





    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter() {


        JwtGrantedAuthoritiesConverter converter =
                new JwtGrantedAuthoritiesConverter();



        converter.setAuthoritiesClaimName("roles");


        converter.setAuthorityPrefix("");



        JwtAuthenticationConverter authenticationConverter =
                new JwtAuthenticationConverter();



        authenticationConverter
            .setJwtGrantedAuthoritiesConverter(converter);



        return authenticationConverter;

    }

}