package com.pasteleria.demo;

import com.pasteleria.demo.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ClienteServiceTest {

    @Autowired
    private ClienteService service;

    @Test
    void testListarClientes() {
        assertFalse(service.listar().isEmpty());
    }
}
