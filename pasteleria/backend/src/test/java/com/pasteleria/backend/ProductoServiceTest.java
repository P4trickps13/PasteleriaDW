package com.pasteleria.backend;

import com.pasteleria.backend.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ProductoServiceTest {

    @Autowired
    private ProductoService service;

    @Test
    void testListarProductos() {
        assertFalse(service.listar().isEmpty());
    }
}
