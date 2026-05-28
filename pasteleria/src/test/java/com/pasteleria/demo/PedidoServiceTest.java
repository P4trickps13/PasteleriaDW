package com.pasteleria.demo;

import com.pasteleria.demo.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class PedidoServiceTest {

    @Autowired
    private PedidoService service;

    @Test
    void testListarPedidos() {
        assertFalse(service.listar().isEmpty());
    }
}
