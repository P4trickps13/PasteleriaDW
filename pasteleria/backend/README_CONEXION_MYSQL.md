# Proyecto Pastelería conectado a MySQL

Este proyecto fue actualizado para trabajar con Spring Data JPA y MySQL. Antes los datos estaban en listas `ArrayList`; ahora se guardan en tablas reales de MySQL.

## 1. Crear o usar la base de datos

Puedes crearla manualmente en MySQL Workbench:

```sql
CREATE DATABASE pasteleria_db;
```

También está activado `createDatabaseIfNotExist=true`, por lo que Spring Boot puede crear la base si el usuario de MySQL tiene permisos.

## 2. Revisar credenciales

Archivo:

```text
src/main/resources/application.properties
```

Configuración actual:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pasteleria_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=America/Lima
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

Cambia `spring.datasource.password` por tu contraseña real de MySQL.

## 3. Ejecutar

```bash
mvn spring-boot:run
```

Al iniciar, Hibernate creará estas tablas:

- `productos`
- `clientes`
- `pedidos`

Además, se cargan datos iniciales desde `DataSeeder.java` si las tablas están vacías.

## 4. Endpoints principales

### Productos

```text
GET  http://localhost:8080/api/productos
GET  http://localhost:8080/api/productos/1
POST http://localhost:8080/api/productos
GET  http://localhost:8080/api/productos/categoria/Tortas
GET  http://localhost:8080/api/productos/precio-mayor?precio=20
GET  http://localhost:8080/api/productos/stock-mayor?stock=5
GET  http://localhost:8080/api/productos/buscar?texto=torta
PUT  http://localhost:8080/api/productos/1/precio?nuevoPrecio=50
PUT  http://localhost:8080/api/productos/1/descontar-stock?cantidad=2
```

Ejemplo JSON para POST de producto:

```json
{
  "nombre": "Torta tres leches",
  "categoria": "Tortas",
  "precio": 60.0,
  "stock": 12
}
```

### Clientes

```text
GET  http://localhost:8080/api/clientes
GET  http://localhost:8080/api/clientes/1
POST http://localhost:8080/api/clientes
GET  http://localhost:8080/api/clientes/correo?correo=patrick@gmail.com
GET  http://localhost:8080/api/clientes/apellido/Perez
```

Ejemplo JSON para POST de cliente:

```json
{
  "nombre": "Ana",
  "apellido": "Ramirez",
  "telefono": "999888777",
  "correo": "ana@gmail.com"
}
```

### Pedidos

```text
GET  http://localhost:8080/api/pedidos
GET  http://localhost:8080/api/pedidos/1
POST http://localhost:8080/api/pedidos
GET  http://localhost:8080/api/pedidos/estado/Pendiente
GET  http://localhost:8080/api/pedidos/cliente?nombre=Patrick
PUT  http://localhost:8080/api/pedidos/1/estado?nuevoEstado=Entregado
```

Ejemplo JSON para POST de pedido:

```json
{
  "cliente": "Ana Ramirez",
  "producto": "Torta tres leches",
  "cantidad": 1,
  "total": 60.0,
  "estado": "Pendiente"
}
```
