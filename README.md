# ForoHub

API REST (Spring Boot 3, Java 17) para el challenge "Foro Hub".

## Endpoints
- `POST /login` → Autenticación (email y password). Devuelve `{ "type": "Bearer", "token": "..." }`.
- `GET /topicos` → Lista tópicos (público).
- `POST /topicos` → Crea un tópico (requiere Bearer token).
- `DELETE /topicos/{id}` → Elimina un tópico (requiere Bearer token).

## Perfiles y base de datos
- **Dev (por defecto):** H2 en memoria.
- **Prod:** PostgreSQL configurado en `application-prod.properties`.

Ejecutar con prod:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

Configura tus credenciales de Postgres:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/forohub
spring.datasource.username=forohub_user
spring.datasource.password=forohub_pass
```

## Usuario por defecto (creado en arranque)
- email: `user@foro.com`
- password: `password`

## Quick Start (dev)
```bash
mvn spring-boot:run
# POST /login  -> obtiene token
# GET /topicos -> lista (200)
# POST /topicos (con Bearer) -> crea (201)
# DELETE /topicos/{id} (con Bearer) -> elimina (204)
```

## Swagger
- `http://localhost:8080/swagger-ui.html`
