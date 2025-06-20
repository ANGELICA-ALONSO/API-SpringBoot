# API-SpringBoot

Este repositorio contiene una API REST desarrollada con Spring Boot para la gestión de clientes. Es un ejemplo de arquitectura en capas típica de aplicaciones Spring Boot, implementando operaciones básicas de CRUD (Crear, Leer, Actualizar y Eliminar) sobre entidades de cliente.

## Funcionalidades principales

La API ofrece los siguientes endpoints para gestionar clientes:

- **Obtener todos los clientes**: `GET /clientes`
- **Obtener un cliente por ID**: `GET /clientes/{id}`
- **Crear un nuevo cliente**: `POST /clientes`
- **Actualizar un cliente existente**: `PUT /clientes/{id}`
- **Eliminar un cliente**: `DELETE /clientes/{id}`

Cada cliente tiene los siguientes atributos principales:
- `id`: Identificador único (autogenerado)
- `nombre`: Nombre del cliente (requerido)
- `apellido`: Apellido del cliente (opcional)
- `email`: Correo electrónico único (requerido)
- `activo`: Estado del cliente (activo/inactivo)

## Estructura del proyecto

- **Controller**: Recibe y responde las peticiones HTTP.
- **Service**: Contiene la lógica de negocio y validaciones.
- **Repository**: Gestiona la persistencia y consulta a la base de datos.

El flujo de una petición es:
```
Petición HTTP <-> Controller <-> Service <-> Repository
```

## Tecnologías utilizadas

- Java
- Spring Boot
- Spring Data JPA
- (Opcional) Base de datos relacional compatible con JPA o en este caso se utlizó H2

## Ejecución

Para ejecutar la aplicación localmente:

1. Clona el repositorio.
2. Asegúrate de tener configurada una base de datos y las credenciales en el archivo `application.properties`.
3. Ejecuta la aplicación con:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Accede a los endpoints usando herramientas como Postman o cURL.

## Pruebas

Incluye pruebas básicas para asegurar el correcto arranque del contexto de Spring Boot.

---

> Este proyecto es un ejemplo educativo para mostrar cómo construir una API REST sencilla con Spring Boot y buenas prácticas de arquitectura.
