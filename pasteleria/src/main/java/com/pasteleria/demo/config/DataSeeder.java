package com.pasteleria.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pasteleria.demo.model.Cliente;
import com.pasteleria.demo.model.Pedido;
import com.pasteleria.demo.model.Producto;
import com.pasteleria.demo.repository.ClienteRepository;
import com.pasteleria.demo.repository.PedidoRepository;
import com.pasteleria.demo.repository.ProductoRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;

    public DataSeeder(ProductoRepository productoRepository, ClienteRepository clienteRepository,
            PedidoRepository pedidoRepository) {
        this.productoRepository = productoRepository;
        this.clienteRepository = clienteRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void run(String... args) {
        if (productoRepository.count() == 0) {
            productoRepository.save(new Producto("Torta de Chocolate", "Tortas", 45.0, 10));
            productoRepository.save(new Producto("Cupcake de Vainilla", "Cupcakes", 8.5, 20));
            productoRepository.save(new Producto("Cheesecake de Fresa", "Tortas", 55.0, 8));
        }

        if (clienteRepository.count() == 0) {
            clienteRepository.save(new Cliente("Patrick", "Perez", "987654321", "patrick@gmail.com"));
            clienteRepository.save(new Cliente("Lucia", "Torres", "912345678", "lucia@gmail.com"));
        }

        if (pedidoRepository.count() == 0) {
            pedidoRepository.save(new Pedido("Patrick Perez", "Torta de Chocolate", 1, 45.0, "Pendiente"));
            pedidoRepository.save(new Pedido("Lucia Torres", "Cupcake de Vainilla", 6, 51.0, "Confirmado"));
        }
    }
}
