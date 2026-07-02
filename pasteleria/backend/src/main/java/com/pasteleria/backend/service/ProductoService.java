package com.pasteleria.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pasteleria.backend.model.Producto;
import com.pasteleria.backend.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> buscarPorCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    public List<Producto> buscarPorPrecioMayorA(double precio) {
        return productoRepository.findByPrecioGreaterThan(precio);
    }

    public List<Producto> buscarPorStockMayorA(int stock) {
        return productoRepository.findByStockGreaterThan(stock);
    }

    public List<Producto> buscarPorTexto(String texto) {
        return productoRepository.buscarPorNombreContiene(texto);
    }

    @Transactional
    public Producto actualizarPrecio(Long id, double nuevoPrecio) {
        Producto producto = obtenerPorId(id);
        producto.setPrecio(nuevoPrecio);
        return productoRepository.save(producto);
    }

    @Transactional
    public void descontarStock(Long id, int cantidad) {
        Producto producto = obtenerPorId(id);

        if (cantidad <= 0) {
            throw new RuntimeException("La cantidad debe ser mayor que cero");
        }

        if (producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente");
        }

        producto.setStock(producto.getStock() - cantidad);
        productoRepository.save(producto);
    }

    @Transactional
    public void eliminar(Long id) {
        Producto producto = obtenerPorId(id);
        productoRepository.delete(producto);
    }
}
