package com.pasteleria.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pasteleria.demo.model.Cliente;
import com.pasteleria.demo.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorCorreo(String correo) {
        return clienteRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con correo: " + correo));
    }

    public List<Cliente> buscarPorApellido(String apellido) {
        return clienteRepository.findByApellido(apellido);
    }
}
