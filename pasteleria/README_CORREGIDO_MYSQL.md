# Pastelería Milis - Versión corregida para MySQL

Esta versión deja el flujo principal así:

React + Vite + TypeScript -> Spring Boot API -> MySQL local

Ya no se usan tablas de Supabase desde el frontend.

## 1. Base de datos

Abre XAMPP y activa MySQL. Luego entra a phpMyAdmin:

http://localhost/phpmyadmin

Crea la base de datos:

```sql
CREATE DATABASE pasteleria_db;
```

El backend también puede crearla porque tiene `createDatabaseIfNotExist=true`, pero es mejor crearla manualmente.

## 2. Configuración de MySQL

Archivo:

```txt
backend/src/main/resources/application.properties
```

Para XAMPP normalmente debe estar así:

```properties
spring.datasource.username=root
spring.datasource.password=
```

Si tu MySQL tiene contraseña, coloca tu contraseña real.

## 3. Ejecutar backend

```bash
cd backend
mvnw.cmd spring-boot:run
```

En Linux/Mac:

```bash
cd backend
./mvnw spring-boot:run
```

Prueba estas rutas en el navegador:

```txt
http://localhost:8080/api/productos
http://localhost:8080/api/hero-slides
http://localhost:8080/api/gallery-items
http://localhost:8080/api/benefits
http://localhost:8080/api/business-hours
http://localhost:8080/api/testimonials
```

Si cargan datos JSON, el backend y MySQL están funcionando.

## 4. Ejecutar frontend

```bash
cd frontend
npm install
npm run dev
```

Abre:

```txt
http://localhost:3000
```

## 5. Qué se corrigió

- Se retiraron las llamadas a Supabase.
- El frontend ahora usa `frontend/src/services/apiService.ts`.
- El carrito ahora usa `nombre`, `categoria` y `precio`, que son los campos reales del backend.
- El checkout ahora guarda en `/api/pedidos`.
- El formulario de encargos especiales ahora guarda en `/api/encargos`.
- El newsletter ahora guarda en `/api/newsletter`.
- Hero, galería, beneficios, horarios y testimonios ahora vienen del backend Spring Boot/MySQL.
- Se agregaron nuevas entidades, repositorios y controladores en Spring Boot.

## 6. Tablas que se crean en MySQL

Hibernate creará automáticamente estas tablas:

- productos
- clientes
- pedidos
- usuarios
- hero_slides
- gallery_items
- benefits
- business_hours
- testimonials
- encargos_personalizados
- newsletter_subscribers

## 7. Error común

Si ves este error:

```txt
Communications link failure / Connection refused
```

significa que MySQL no está prendido o que el usuario/contraseña de `application.properties` no coincide.
