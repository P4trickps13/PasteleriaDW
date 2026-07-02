package com.pasteleria.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pasteleria.backend.model.NewsletterSubscriber;
import com.pasteleria.backend.repository.NewsletterSubscriberRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/newsletter")
public class NewsletterController {
    private final NewsletterSubscriberRepository repository;
    public NewsletterController(NewsletterSubscriberRepository repository) { this.repository = repository; }
    @GetMapping
    public List<NewsletterSubscriber> listar() { return repository.findAll(); }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewsletterSubscriber guardar(@RequestBody NewsletterSubscriber subscriber) { return repository.save(subscriber); }
}
