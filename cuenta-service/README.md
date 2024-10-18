# Microservicio cuentas-movimientos

Este proyecto implementa un microservicio: **cuentas-movimientos** Se utiliza RabbitMQ para la comunicación entre el microservicio y se proporcionan los servicios CRUD.

## Requisitos

- **Java JDK** (versión 17 o superior).
- **Maven**: Para gestionar las dependencias y la construcción del proyecto.
- **Docker**: Para levantar los servicios de **MySQL** y **RabbitMQ** en producción.
- **RabbitMQ**: Configurado en Docker para la mensajería entre microservicios.
- **H2**: Para las pruebas unitarias, usamos una base de datos en memoria **H2**.

## Ejecutar Pruebas

Para ejecutar las pruebas unitarias de manera local, usa el siguiente comando:

```bash
mvn test
```

## Ejecutar Local Desarrollo

Para ejecutar spring-boot en modo desarrollo, usa el siguiente comando, este inicializa las variables de entorno:

```bash
export $(cat .env | xargs) && mvn spring-boot:run
```