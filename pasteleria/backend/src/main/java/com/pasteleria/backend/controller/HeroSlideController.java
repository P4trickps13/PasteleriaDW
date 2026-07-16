package com.pasteleria.backend.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pasteleria.backend.model.HeroSlide;
import com.pasteleria.backend.repository.HeroSlideRepository;

@RestController

@RequestMapping("/api/hero-slides")
public class HeroSlideController {
    private final HeroSlideRepository repository;
    public HeroSlideController(HeroSlideRepository repository) { this.repository = repository; }
    @GetMapping
    public List<HeroSlide> listarActivos() { return repository.findByActiveTrueOrderBySortOrderAsc(); }
    @PostMapping
    public HeroSlide guardar(@RequestBody HeroSlide item) { return repository.save(item); }
}
