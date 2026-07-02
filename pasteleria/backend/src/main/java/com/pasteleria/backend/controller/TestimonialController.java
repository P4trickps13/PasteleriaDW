package com.pasteleria.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pasteleria.backend.model.Testimonial;
import com.pasteleria.backend.repository.TestimonialRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/testimonials")
public class TestimonialController {
    private final TestimonialRepository repository;
    public TestimonialController(TestimonialRepository repository) { this.repository = repository; }
    @GetMapping
    public List<Testimonial> listarActivos() { return repository.findByActiveTrueOrderBySortOrderAsc(); }
    @PostMapping
    public Testimonial guardar(@RequestBody Testimonial item) { return repository.save(item); }
}
