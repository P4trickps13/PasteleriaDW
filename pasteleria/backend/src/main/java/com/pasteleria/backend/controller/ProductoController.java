package com.pasteleria.backend.controller;

import com.pasteleria.backend.model.Producto;
import com.pasteleria.backend.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Producto> buscarPorCategoria(@PathVariable String categoria) {
        return productoService.buscarPorCategoria(categoria);
    }

    @GetMapping("/precio-mayor")
    public List<Producto> buscarPorPrecioMayorA(@RequestParam double precio) {
        return productoService.buscarPorPrecioMayorA(precio);
    }

    @GetMapping("/stock-mayor")
    public List<Producto> buscarPorStockMayorA(@RequestParam int stock) {
        return productoService.buscarPorStockMayorA(stock);
    }

    @GetMapping("/buscar")
    public List<Producto> buscarPorTexto(@RequestParam String texto) {
        return productoService.buscarPorTexto(texto);
    }

    @PutMapping("/{id}/precio")
    public Producto actualizarPrecio(@PathVariable Long id, @RequestParam double nuevoPrecio) {
        return productoService.actualizarPrecio(id, nuevoPrecio);
    }

    @PutMapping("/{id}/descontar-stock")
    public void descontarStock(@PathVariable Long id, @RequestParam int cantidad) {
        productoService.descontarStock(id, cantidad);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
