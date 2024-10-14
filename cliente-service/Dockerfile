
# Paso 1: Construcción del JAR
FROM maven:3.8.5-openjdk-17-slim AS build

# Establecemos el directorio de trabajo en el contenedor
WORKDIR /app

COPY pom.xml .
COPY src ./src

# Ejecutamos Maven para compilar el proyecto y generar el archivo JAR
RUN mvn clean package -DskipTests

# Paso 2: Ejecutar el JAR
# Imagen de OpenJDK para ejecutar el archivo JAR generado
FROM openjdk:17-jdk-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR desde el contenedor de construcción
COPY --from=build /app/target/*.jar /app/app.jar

# Exponemos el puerto
EXPOSE 8080

# Ejecutar el JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
