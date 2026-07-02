package com.pasteleria.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pasteleria.backend.model.Benefit;

public interface BenefitRepository extends JpaRepository<Benefit, Long> {
    List<Benefit> findByActiveTrueOrderBySortOrderAsc();
}
