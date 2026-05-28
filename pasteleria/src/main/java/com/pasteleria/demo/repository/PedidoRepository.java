package com.pasteleria.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pasteleria.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByEstado(String estado);

    @Query("SELECT p FROM Pedido p WHERE LOWER(p.cliente) LIKE LOWER(CONCAT('%', :cliente, '%'))")
    List<Pedido> buscarPorCliente(@Param("cliente") String cliente);
}
