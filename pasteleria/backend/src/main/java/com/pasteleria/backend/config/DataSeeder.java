package com.pasteleria.backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pasteleria.backend.model.Benefit;
import com.pasteleria.backend.model.BusinessHour;
import com.pasteleria.backend.model.Cliente;
import com.pasteleria.backend.model.GalleryItem;
import com.pasteleria.backend.model.HeroSlide;
import com.pasteleria.backend.model.Pedido;
import com.pasteleria.backend.model.Producto;
import com.pasteleria.backend.model.Testimonial;
import com.pasteleria.backend.repository.BenefitRepository;
import com.pasteleria.backend.repository.BusinessHourRepository;
import com.pasteleria.backend.repository.ClienteRepository;
import com.pasteleria.backend.repository.GalleryItemRepository;
import com.pasteleria.backend.repository.HeroSlideRepository;
import com.pasteleria.backend.repository.PedidoRepository;
import com.pasteleria.backend.repository.ProductoRepository;
import com.pasteleria.backend.repository.TestimonialRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;
    private final HeroSlideRepository heroSlideRepository;
    private final GalleryItemRepository galleryItemRepository;
    private final BenefitRepository benefitRepository;
    private final BusinessHourRepository businessHourRepository;
    private final TestimonialRepository testimonialRepository;

    public DataSeeder(
            ProductoRepository productoRepository,
            ClienteRepository clienteRepository,
            PedidoRepository pedidoRepository,
            HeroSlideRepository heroSlideRepository,
            GalleryItemRepository galleryItemRepository,
            BenefitRepository benefitRepository,
            BusinessHourRepository businessHourRepository,
            TestimonialRepository testimonialRepository) {
        this.productoRepository = productoRepository;
        this.clienteRepository = clienteRepository;
        this.pedidoRepository = pedidoRepository;
        this.heroSlideRepository = heroSlideRepository;
        this.galleryItemRepository = galleryItemRepository;
        this.benefitRepository = benefitRepository;
        this.businessHourRepository = businessHourRepository;
        this.testimonialRepository = testimonialRepository;
    }

    @Override
    public void run(String... args) {
        if (productoRepository.count() == 0) {
            productoRepository.save(new Producto("Torta de Chocolate", "Tortas", 45.0, 10));
            productoRepository.save(new Producto("Cupcake de Vainilla", "Cupcakes", 8.5, 20));
            productoRepository.save(new Producto("Cheesecake de Fresa", "Tortas", 55.0, 8));
            productoRepository.save(new Producto("Pan artesanal", "Panes", 6.0, 25));
            productoRepository.save(new Producto("Brownie clásico", "Postres", 7.5, 18));
            productoRepository.save(new Producto("Macarons surtidos", "Postres", 12.0, 15));
        }

        if (clienteRepository.count() == 0) {
            clienteRepository.save(new Cliente("Patrick", "Perez", "987654321", "patrick@gmail.com"));
            clienteRepository.save(new Cliente("Lucia", "Torres", "912345678", "lucia@gmail.com"));
        }

        if (pedidoRepository.count() == 0) {
            pedidoRepository.save(new Pedido("Patrick Perez", "Torta de Chocolate", 1, 45.0, "Pendiente"));
            pedidoRepository.save(new Pedido("Lucia Torres", "Cupcake de Vainilla", 6, 51.0, "Confirmado"));
        }

        if (heroSlideRepository.count() == 0) {
            heroSlideRepository.save(new HeroSlide(
                    "https://images.unsplash.com/photo-1486427944299-d1955d23e34d?w=1600&h=1000&fit=crop",
                    "Pastelería Milis",
                    "Dulces momentos hechos con amor",
                    "Tortas, cupcakes, panes artesanales y postres preparados con ingredientes frescos.",
                    true,
                    1));
            heroSlideRepository.save(new HeroSlide(
                    "https://images.unsplash.com/photo-1578985545062-69928b1d9587?w=1600&h=1000&fit=crop",
                    "Especialidad de la casa",
                    "Tortas para toda ocasión",
                    "Diseños personalizados para cumpleaños, reuniones familiares y eventos especiales.",
                    true,
                    2));
        }

        if (galleryItemRepository.count() == 0) {
            galleryItemRepository.save(new GalleryItem("Tortas personalizadas", "Diseños especiales para celebrar momentos inolvidables.", "Tortas", "https://images.unsplash.com/photo-1578985545062-69928b1d9587?w=900&h=1200&fit=crop", "main", true, 1));
            galleryItemRepository.save(new GalleryItem("Cupcakes decorados", "Pequeños detalles llenos de sabor y color.", "Cupcakes", "https://images.unsplash.com/photo-1587668178277-295251f900ce?w=900&h=1200&fit=crop", "main", true, 2));
            galleryItemRepository.save(new GalleryItem("Postres artesanales", "Recetas caseras con presentación delicada.", "Postres", "https://images.unsplash.com/photo-1488477181946-6428a0291777?w=900&h=1200&fit=crop", "main", true, 3));
            galleryItemRepository.save(new GalleryItem("Macarons", "Colores suaves y textura perfecta.", "Dulces", "https://images.unsplash.com/photo-1569864358642-9d1684040f43?w=700&h=700&fit=crop", "extra", true, 4));
            galleryItemRepository.save(new GalleryItem("Panadería", "Panes frescos para cada día.", "Panes", "https://images.unsplash.com/photo-1509440159596-0249088772ff?w=700&h=700&fit=crop", "extra", true, 5));
            galleryItemRepository.save(new GalleryItem("Cheesecake", "Cremoso, fresco y balanceado.", "Especial", "https://images.unsplash.com/photo-1533134242443-d4fd215305ad?w=700&h=700&fit=crop", "extra", true, 6));
        }

        if (benefitRepository.count() == 0) {
            benefitRepository.save(new Benefit("ri-cake-3-line", "Preparación artesanal", "Cada producto se hornea con cuidado y dedicación.", "bg-white", "text-amber-700", "bg-amber-50", true, 1));
            benefitRepository.save(new Benefit("ri-heart-3-line", "Ingredientes frescos", "Usamos insumos seleccionados para mantener calidad y sabor.", "bg-white", "text-rose-600", "bg-rose-50", true, 2));
            benefitRepository.save(new Benefit("ri-truck-line", "Pedidos coordinados", "Confirmamos cada detalle antes de preparar tu compra.", "bg-white", "text-green-700", "bg-green-50", true, 3));
            benefitRepository.save(new Benefit("ri-gift-line", "Detalles especiales", "Decoración, empaques y encargos para fechas importantes.", "bg-white", "text-purple-700", "bg-purple-50", true, 4));
        }

        if (businessHourRepository.count() == 0) {
            businessHourRepository.save(new BusinessHour(0, "Lunes", "08:00", "20:00", false, true));
            businessHourRepository.save(new BusinessHour(1, "Martes", "08:00", "20:00", false, true));
            businessHourRepository.save(new BusinessHour(2, "Miércoles", "08:00", "20:00", false, true));
            businessHourRepository.save(new BusinessHour(3, "Jueves", "08:00", "20:00", false, true));
            businessHourRepository.save(new BusinessHour(4, "Viernes", "08:00", "20:00", false, true));
            businessHourRepository.save(new BusinessHour(5, "Sábado", "09:00", "18:00", false, true));
            businessHourRepository.save(new BusinessHour(6, "Domingo", null, null, true, true));
        }

        if (testimonialRepository.count() == 0) {
            testimonialRepository.save(new Testimonial("Ana Torres", "Cliente frecuente", "https://images.unsplash.com/photo-1494790108377-be9c29b29330?w=200&h=200&fit=crop", 5, "La torta quedó hermosa y el sabor fue excelente. Muy buena atención.", true, 1));
            testimonialRepository.save(new Testimonial("Carlos Ríos", "Pedido para cumpleaños", "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=200&h=200&fit=crop", 5, "Me ayudaron a elegir el diseño y todo llegó tal como lo pedí.", true, 2));
        }
    }
}
