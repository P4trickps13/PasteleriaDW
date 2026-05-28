package com.pasteleria.demo.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PerfilController {

    @GetMapping("/perfil")
    public String perfil(Principal principal) {
        return "Usuario autenticado: " + principal.getName();
    }
}
