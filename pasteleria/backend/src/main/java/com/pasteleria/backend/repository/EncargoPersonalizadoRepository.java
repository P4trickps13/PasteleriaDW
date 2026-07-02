package com.pasteleria.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pasteleria.backend.model.EncargoPersonalizado;

public interface EncargoPersonalizadoRepository extends JpaRepository<EncargoPersonalizado, Long> {
    List<EncargoPersonalizado> findByEstado(String estado);
}
