package com.pasteleria.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pasteleria.backend.model.GalleryItem;
import com.pasteleria.backend.repository.GalleryItemRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/gallery-items")
public class GalleryItemController {
    private final GalleryItemRepository repository;
    public GalleryItemController(GalleryItemRepository repository) { this.repository = repository; }
    @GetMapping
    public List<GalleryItem> listarActivos() { return repository.findByActiveTrueOrderBySortOrderAsc(); }
    @PostMapping
    public GalleryItem guardar(@RequestBody GalleryItem item) { return repository.save(item); }
}
