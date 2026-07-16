package com.pasteleria.backend.controller;

import com.pasteleria.backend.model.Cliente;
import com.pasteleria.backend.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable Long id) {
        return clienteService.obtenerPorId(id);
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @GetMapping("/correo")
    public Cliente buscarPorCorreo(@RequestParam String correo) {
        return clienteService.buscarPorCorreo(correo);
    }

    @GetMapping("/apellido/{apellido}")
    public List<Cliente> buscarPorApellido(@PathVariable String apellido) {
        return clienteService.buscarPorApellido(apellido);
    }
}
