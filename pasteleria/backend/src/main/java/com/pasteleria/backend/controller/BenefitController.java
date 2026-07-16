package com.pasteleria.backend.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pasteleria.backend.model.Benefit;
import com.pasteleria.backend.repository.BenefitRepository;

@RestController

@RequestMapping("/api/benefits")
public class BenefitController {
    private final BenefitRepository repository;
    public BenefitController(BenefitRepository repository) { this.repository = repository; }
    @GetMapping
    public List<Benefit> listarActivos() { return repository.findByActiveTrueOrderBySortOrderAsc(); }
    @PostMapping
    public Benefit guardar(@RequestBody Benefit item) { return repository.save(item); }
}
