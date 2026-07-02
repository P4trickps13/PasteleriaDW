package com.pasteleria.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pasteleria.backend.model.BusinessHour;
import com.pasteleria.backend.repository.BusinessHourRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/business-hours")
public class BusinessHourController {
    private final BusinessHourRepository repository;
    public BusinessHourController(BusinessHourRepository repository) { this.repository = repository; }
    @GetMapping
    public List<BusinessHour> listarActivos() { return repository.findByActiveTrueOrderByDayIndexAsc(); }
    @PostMapping
    public BusinessHour guardar(@RequestBody BusinessHour item) { return repository.save(item); }
}
