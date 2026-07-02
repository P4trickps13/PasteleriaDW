import { useEffect, useState } from 'react';
import ProductCard from './ProductCard';
import type { Producto } from '@/services/productoService';
import { obtenerProductos } from '@/services/productoService';

const categories = ['todos', 'Tortas', 'Cupcakes'];

interface ProductsSectionProps {
  onAddToCart: (product: Producto) => void;
}

export default function ProductsSection({ onAddToCart }: ProductsSectionProps) {
  const [activeCategory, setActiveCategory] = useState('todos');
  const [products, setProducts] = useState<Producto[]>([]);

  useEffect(() => {
    async function fetchProducts() {
      try {
        const data = await obtenerProductos();
        setProducts(data);
      } catch (error) {
        console.error('Error cargando productos desde Spring Boot:', error);
      }
    }

    fetchProducts();
  }, []);

  const filtered =
    activeCategory === 'todos'
      ? products
      : products.filter(p => p.categoria === activeCategory);

  return (
    <section id="productos" className="py-24 px-6 md:px-12 bg-white">
      <div className="max-w-6xl mx-auto">
        <div className="flex flex-col md:flex-row md:items-end justify-between gap-6 mb-12">
          <div>
            <span className="text-amber-700 text-xs tracking-[0.3em] uppercase font-medium mb-3 block">
              Nuestros Productos
            </span>
            <h2
              className="text-4xl md:text-5xl font-bold text-stone-900 leading-tight"
              style={{ fontFamily: "'Playfair Display', serif" }}
            >
              Selección<br />
              <span className="text-amber-700">artesanal</span>
            </h2>
          </div>

          <p className="text-stone-500 text-sm max-w-xs leading-relaxed">
            Cada producto se elabora diariamente con ingredientes frescos y recetas de autor desarrolladas por nuestros maestros pasteleros.
          </p>
        </div>

        <div className="flex gap-2 flex-wrap mb-10">
          {categories.map(cat => (
            <button
              key={cat}
              onClick={() => setActiveCategory(cat)}
              className={`px-5 py-2 rounded-full text-sm font-medium transition-all cursor-pointer whitespace-nowrap capitalize ${
                activeCategory === cat
                  ? 'bg-amber-800 text-white'
                  : 'bg-stone-100 text-stone-600 hover:bg-stone-200'
              }`}
            >
              {cat === 'todos' ? 'Todos' : cat}
            </button>
          ))}
        </div>

        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6" data-product-shop>
          {filtered.map(product => (
            <ProductCard
              key={product.id}
              product={product}
              onAddToCart={onAddToCart}
            />
          ))}
        </div>
      </div>
    </section>
  );
}