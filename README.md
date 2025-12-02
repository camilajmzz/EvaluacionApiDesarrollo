## API REST: Gestión de Proyectos de Desarrollo de microservicios(ApiDesarrollo)

Este proyecto implementa una API RESTful desarrollada con **Spring Boot 3** y **Java 17** para gestionar la información de proyectos de desarrollo, incluyendo sus estados, tecnologías utilizadas y los desarrolladores asignados.

La API se basa en un esquema relacional con relaciones Muchos a Muchos (M:M) entre Proyectos, Desarrolladores y Tecnologías.

## Objetivo de la Aplicación

El objetivo principal es exponer todos los **endpoints** necesarios para que un cliente (como un frontend web o Postman) pueda realizar las cuatro operaciones CRUD (Crear, Leer, Actualizar, Borrar) sobre las entidades principales del sistema (`Proyecto`, `Desarrollador`, `Tecnologia`) y cumplir con los requisitos específicos de la evaluación.

## Arquitectura y Estructura del Proyecto

El proyecto sigue una estructura modular y limpia basada en el patrón **Controlador-Servicio-Repositorio (MVC/CSR)** para garantizar la separación de responsabilidades:

1.  **`Controller`**: Capa de entrada. Recibe las peticiones HTTP y devuelve las respuestas (utilizando `ResponseEntity`). Se encarga de la validación inicial y de la comunicación con la capa de Servicio.
2.  **`Service`**: Capa de Lógica de Negocio. Contiene la lógica de aplicación, maneja las transacciones y coordina las operaciones entre la capa de Controlador y Repositorio.
3.  **`Repository` (Persistance)**: Capa de Persistencia. Extiende `JpaRepository` y se encarga de las operaciones directas de CRUD con la base de datos (MySQL) utilizando Hibernate.
4.  **`Model` (Persistance)**: Contiene las entidades JPA (`@Entity`) que mapean las tablas de la base de datos.
5.  **`DTO` (Data Transfer Object)**: Se utilizan para la transferencia de datos entre las capas de la API y el cliente, asegurando el desacoplamiento de la estructura de la base de datos.

## Configuración y Ejecución

### Requisitos

* JDK 17 o superior.
* Apache Maven.
* Servidor de Base de Datos **MySQL 8.0+**.

### Base de Datos

El proyecto se conecta a una base de datos MySQL. La configuración se encuentra en `src/main/resources/application.yaml`.

* **URL de la BD:** `jdbc:mysql://localhost:3306/apidesarrollo`
* **Hibernate:** Utiliza la propiedad `ddl-auto: update` para crear las tablas automáticamente si no existen, basándose en las entidades JPA.
* **Datos Iniciales:** Se introdujo manualmente los datos iniciales en mySQL workbench
### Inicio del Servidor

El servidor arranca en el puerto `8080`.

```bash
# Ejecutar la aplicación Spring Boot
mvn spring-boot:run

