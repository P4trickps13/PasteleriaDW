# ProyectoFinalPasteleria

Estructura corregida:

- `backend/`: Spring Boot con paquetes MVC: config, controller, dto, model, repository y service.
- `frontend/`: Frontend React/Vite reciclado desde PasteleriamilisHD, sin `node_modules`.
- `referencias/`: copias de apoyo de los ZIP originales, también sin `node_modules`.

Para instalar frontend:

```bash
cd frontend
npm install
npm run dev
```

Para ejecutar backend cuando se configure MySQL:

```bash
cd backend
.\mvnw spring-boot:run
```

Antes de ejecutar backend, cambiar `TU_PASSWORD` en `backend/src/main/resources/application.properties`.
