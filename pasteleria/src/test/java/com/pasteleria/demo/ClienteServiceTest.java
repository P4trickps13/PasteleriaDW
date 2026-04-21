package com.pasteleria.demo;

import com.pasteleria.demo.service.ClienteService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ClienteServiceTest {

    @Test
    void testListarClientes() {
        ClienteService service = new ClienteService();
        assertFalse(service.listar().isEmpty());
    }
}