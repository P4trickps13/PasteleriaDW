package com.pasteleria.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pasteleria.backend.model.BusinessHour;

public interface BusinessHourRepository extends JpaRepository<BusinessHour, Long> {
    List<BusinessHour> findByActiveTrueOrderByDayIndexAsc();
}
