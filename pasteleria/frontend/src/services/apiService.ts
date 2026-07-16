const API_BASE_URL = '/api';

async function request<T>(path: string, options?: RequestInit): Promise<T> {
  const response = await fetch(`${API_BASE_URL}${path}`, {
    headers: {
      'Content-Type': 'application/json',
      ...(options?.headers || {}),
    },
    ...options,
  });

  if (!response.ok) {
    let detail = '';

    try {
      detail = await response.text();
    } catch {
      detail = '';
    }

    throw new Error(detail || `Error HTTP ${response.status}`);
  }

  return response.json();
}


export interface Producto {
  id: number;
  nombre: string;
  categoria: string;
  precio: number;
  stock: number;
}


export interface HeroSlide {
  id: number;
  image: string;
  tagline: string;
  title: string;
  subtitle: string;
  active: boolean;
  sortOrder: number;
}


export interface GalleryItem {
  id: number;
  title: string;
  subtitle: string | null;
  label: string;
  image: string;
  type: string;
  active: boolean;
  sortOrder: number;
}


export interface Benefit {
  id: number;
  icon: string;
  title: string;
  description: string;
  bgClass: string;
  iconColorClass: string;
  accentClass: string;
  active: boolean;
  sortOrder: number;
}


export interface BusinessHour {
  id: number;
  dayIndex: number;
  dayName: string;
  openTime: string | null;
  closeTime: string | null;
  closed: boolean;
  active: boolean;
}


export interface Testimonial {
  id: number;
  name: string;
  role: string;
  avatar: string;
  rating: number;
  text: string;
  active: boolean;
  sortOrder: number;
}


export interface PedidoPayload {
  cliente: string;
  correo: string;
  telefono: string;
  direccion: string;
  ciudad: string;
  notas?: string;
  producto: string;
  cantidad: number;
  total: number;
  estado: string;
}


export interface EncargoPayload {
  nombre: string;
  email: string;
  telefono: string;
  tipoProducto: string;
  fechaEvento: string;
  presupuesto?: string;
  personas?: number | null;
  descripcion: string;
  estado: string;
}


export function obtenerProductos() {
  return request<Producto[]>('/productos');
}


export function obtenerHeroSlides() {
  return request<HeroSlide[]>('/hero-slides');
}


export function obtenerGaleria() {
  return request<GalleryItem[]>('/gallery-items');
}


export function obtenerBeneficios() {
  return request<Benefit[]>('/benefits');
}


export function obtenerHorarios() {
  return request<BusinessHour[]>('/business-hours');
}


export function obtenerTestimonios() {
  return request<Testimonial[]>('/testimonials');
}


export function registrarPedido(payload: PedidoPayload) {
  return request<{ id: number }>('/pedidos', {
    method: 'POST',
    body: JSON.stringify(payload),
  });
}


export function registrarEncargo(payload: EncargoPayload) {
  return request<{ id: number }>('/encargos', {
    method: 'POST',
    body: JSON.stringify(payload),
  });
}


export function registrarNewsletter(email: string) {
  return request<{ id: number }>('/newsletter', {
    method: 'POST',
    body: JSON.stringify({ email }),
  });
}