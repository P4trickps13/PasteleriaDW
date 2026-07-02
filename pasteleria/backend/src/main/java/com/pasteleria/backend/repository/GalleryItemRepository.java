package com.pasteleria.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pasteleria.backend.model.GalleryItem;

public interface GalleryItemRepository extends JpaRepository<GalleryItem, Long> {
    List<GalleryItem> findByActiveTrueOrderBySortOrderAsc();
}
