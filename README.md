# API videojuegos

Esta aplicación es un sistema de gestión de inventario 
para una tienda de videojuegos desarrollado durante el 
semillero de Devco, con documentación en swagger, aplicando  arquitectura 
hexagonal, principios SOLID, e implementación de contenedores con Docker,
pruebas unitarias y análisis de código estático con SonarCloud. 

## Pre-Requisitos

* Docker Engine.
* Docker Compose. 

O instalar Docker Desktop que ofrece ambas herramientas.

[Link a Docker Desktop](https://www.docker.com/products/docker-desktop/)


## Despliegue

Ejecutar el siguiente comando en la ruta del proyecto, este levantara la aplicación Sprinboot y la base de datos Mysql.

```
$ docker compose up
