import { useState } from 'react';
import type { Producto } from '@/services/productoService';

interface ProductCardProps {
  product: Producto;
  onAddToCart: (product: Producto) => void;
}

const imagenPorCategoria: Record<string, string> = {
  Tortas:
    'https://images.unsplash.com/photo-1578985545062-69928b1d9587?w=600&h=600&fit=crop',
  Cupcakes:
    'https://images.unsplash.com/photo-1587668178277-295251f900ce?w=600&h=600&fit=crop',
};

export default function ProductCard({ product, onAddToCart }: ProductCardProps) {
  const [added, setAdded] = useState(false);

  const handleAdd = () => {
    onAddToCart(product);
    setAdded(true);
    setTimeout(() => setAdded(false), 1500);
  };

  const image =
    imagenPorCategoria[product.categoria] ||
    'https://images.unsplash.com/photo-1486427944299-d1955d23e34d?w=600&h=600&fit=crop';

  return (
    <div className="group bg-white rounded-2xl overflow-hidden border border-stone-100 hover:border-amber-200 transition-all duration-300">
      <div className="relative overflow-hidden" style={{ height: '240px' }}>
        <img
          src={image}
          alt={product.nombre}
          className="w-full h-full object-cover object-top group-hover:scale-105 transition-transform duration-500"
        />

        <span className="absolute top-3 left-3 bg-amber-800 text-white text-xs font-medium px-3 py-1 rounded-full">
          {product.categoria}
        </span>

        <div className="absolute inset-0 bg-gradient-to-t from-black/20 to-transparent opacity-0 group-hover:opacity-100 transition-opacity duration-300" />
      </div>

      <div className="p-5">
        <span className="text-amber-600 text-xs font-medium uppercase tracking-wider mb-1 block capitalize">
          {product.categoria}
        </span>

        <h3
          className="text-stone-900 font-semibold text-base mb-2 leading-tight"
          style={{ fontFamily: "'Playfair Display', serif" }}
        >
          {product.nombre}
        </h3>

        <p className="text-stone-500 text-xs leading-relaxed mb-4 line-clamp-2">
          Stock disponible: {product.stock}
        </p>

        <div className="flex items-center justify-between">
          <span className="text-stone-900 font-bold text-xl">
            S/ {product.precio.toFixed(2)}
          </span>

          <button
            onClick={handleAdd}
            disabled={product.stock === 0}
            className={`flex items-center gap-2 px-4 py-2.5 rounded-full text-sm font-medium transition-all duration-300 cursor-pointer whitespace-nowrap ${
              added
                ? 'bg-green-600 text-white'
                : product.stock === 0
                ? 'bg-stone-100 text-stone-400 cursor-not-allowed'
                : 'bg-amber-800 hover:bg-amber-900 text-white'
            }`}
          >
            {added ? (
              <>
                <i className="ri-check-line" />
                Agregado
              </>
            ) : product.stock === 0 ? (
              'Agotado'
            ) : (
              <>
                <i className="ri-shopping-bag-line" />
                Agregar
              </>
            )}
          </button>
        </div>
      </div>
    </div>
  );
}