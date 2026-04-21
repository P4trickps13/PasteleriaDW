package com.pasteleria.demo.service;

import com.pasteleria.demo.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private List<Cliente> lista = new ArrayList<>();

    public ClienteService() {
        lista.add(new Cliente(1, "Patrick", "Perez", "987654321", "patrick@gmail.com"));
        lista.add(new Cliente(2, "Lucia", "Torres", "912345678", "lucia@gmail.com"));
    }

    public List<Cliente> listar() {
        return lista;
    }

    public Cliente obtenerPorId(int id) {
        return lista.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Cliente guardar(Cliente cliente) {
        lista.add(cliente);
        return cliente;
    }
}