package com.pasteleria.demo.service;

import com.pasteleria.demo.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private List<Pedido> lista = new ArrayList<>();

    public PedidoService() {
        lista.add(new Pedido(1, "Patrick Perez", "Torta de Chocolate", 1, 45.0, "Pendiente"));
        lista.add(new Pedido(2, "Lucia Torres", "Cupcake de Vainilla", 6, 51.0, "Confirmado"));
    }

    public List<Pedido> listar() {
        return lista;
    }

    public Pedido obtenerPorId(int id) {
        return lista.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Pedido guardar(Pedido pedido) {
        lista.add(pedido);
        return pedido;
    }
}