# Foro API
<p align="center">
  <img src="https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green">
  <img src="https://img.shields.io/badge/Version-1.0-blue">
  <img src="https://img.shields.io/badge/API-Exchange%20Rate-red">
  <img src="https://img.shields.io/badge/LICENSE-NOT%20SPECIFIED-white">
  
</p>

Este proyecto es una API desarrollada en Java 17 con Spring Boot que simula un foro para una escuela. Los estudiantes pueden interactuar con el foro creando, actualizando, eliminando y listando tópicos relacionados con cursos y dudas académicas. La API también está protegida mediante seguridad para garantizar que solo los usuarios autorizados puedan acceder a las operaciones del CRUD.

---

## Características

- **CRUD completo de tópicos:**
  - Crear un nuevo tópico.
  - Listar todos los tópicos.
  - Ver detalles de un tópico específico.
  - Actualizar un tópico existente.
  - Eliminar un tópico.

- **Datos manejados por tópicos:**
  - Título.
  - Curso relacionado.
  - Mensaje del estudiante.
  - Fechas de creación y actualización.

- **Conexión a MySQL:**
  - Todos los datos se almacenan en una base de datos relacional MySQL.

- **Seguridad:**
  - Solo los usuarios autenticados pueden interactuar con la API.

- **Estructura modular:**
  - Diseño flexible para agregar futuras mejoras, como tablas de usuarios y cursos.

---

## Requisitos

- **Java 17**
- **Maven**
- **MySQL**
- **Postman** o herramienta similar para probar los endpoints.

---

## Configuración del proyecto

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/SenzaNomeca/forohub.git
   cd forohub
