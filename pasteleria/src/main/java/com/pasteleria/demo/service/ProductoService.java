package com.pasteleria.demo.service;

import com.pasteleria.demo.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private List<Producto> lista = new ArrayList<>();

    public ProductoService() {
        lista.add(new Producto(1, "Torta de Chocolate", "Tortas", 45.0, 10));
        lista.add(new Producto(2, "Cupcake de Vainilla", "Cupcakes", 8.5, 20));
    }

    public List<Producto> listar() {
        return lista;
    }

    public Producto obtenerPorId(int id) {
        return lista.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Producto guardar(Producto producto) {
        lista.add(producto);
        return producto;
    }
}