package com.pasteleria.backend.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pasteleria.backend.model.EncargoPersonalizado;
import com.pasteleria.backend.repository.EncargoPersonalizadoRepository;

@RestController

@RequestMapping("/api/encargos")
public class EncargoPersonalizadoController {
    private final EncargoPersonalizadoRepository repository;
    public EncargoPersonalizadoController(EncargoPersonalizadoRepository repository) { this.repository = repository; }
    @GetMapping
    public List<EncargoPersonalizado> listar() { return repository.findAll(); }
    @PostMapping
    public EncargoPersonalizado guardar(@RequestBody EncargoPersonalizado encargo) { return repository.save(encargo); }
}
