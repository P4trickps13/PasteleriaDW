# Implementación de Spring Security + JWT

Se integró la guía del laboratorio al proyecto `pasteleria`.

## Endpoints agregados

### Público
- `GET /publico/saludo`

### Autenticación
- `POST /auth/register`

```json
{
  "nombre": "Usuario Demo",
  "email": "user@demo.com",
  "password": "123456",
  "rol": "USER"
}
```

- `POST /auth/login`

```json
{
  "email": "user@demo.com",
  "password": "123456"
}
```

Respuesta esperada:

```json
{
  "token": "eyJ...",
  "tipo": "Bearer",
  "email": "user@demo.com",
  "rol": "ROLE_USER"
}
```

### Perfil protegido
- `GET /api/perfil` requiere token Bearer.

### Admin
- `GET /admin/panel` requiere rol `ADMIN`.

## Protección de productos

- `GET /api/productos/**`: USER o ADMIN
- `POST /api/productos/**`: ADMIN
- `PUT /api/productos/**`: ADMIN
- `DELETE /api/productos/**`: ADMIN

## Configuración

La clave JWT y la expiración se configuraron en `src/main/resources/application.properties`:

```properties
app.jwt.secret=EsteEsUnSecretoMuyLargoParaFirmarTokensJwtDeLaboratorioPasteleria1234567890
app.jwt.expiration-minutes=60
```

En producción, la clave debe moverse a una variable de entorno o gestor de secretos.
