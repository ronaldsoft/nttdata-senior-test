# Proyecto Senior Engineer - Proof NTTDATA

Este proyecto implementa dos microservicios: **Cliente-persona** y **Cuenta-movimientos**. Se utiliza RabbitMQ para la comunicación entre los microservicios y se proporcionan reportes en formato JSON que incluyen información sobre cuentas y movimientos de clientes.

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
