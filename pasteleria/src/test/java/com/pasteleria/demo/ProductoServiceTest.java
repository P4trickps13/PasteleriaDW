package com.pasteleria.demo;

import com.pasteleria.demo.service.ProductoService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoServiceTest {

    @Test
    void testListarProductos() {
        ProductoService service = new ProductoService();
        assertFalse(service.listar().isEmpty());
    }
}