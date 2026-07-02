package com.pasteleria.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publico")
public class PublicoController {

    @GetMapping("/saludo")
    public String saludoPublico() {
        return "Este endpoint es público. No requiere token.";
    }
}
