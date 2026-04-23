package com.pasteleria.demo;

import com.pasteleria.demo.service.PedidoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class PedidoServiceTest {

    @Test
    void testListarPedidos() {
        PedidoService service = new PedidoService();
        assertFalse(service.listar().isEmpty());
    }
}