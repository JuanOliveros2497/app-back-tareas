# Usar imagen oficial de Maven para construir el proyecto
FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app

# Copiar archivos del proyecto
COPY . .

# Dar permisos de ejecución al wrapper mvnw (por si acaso)
RUN chmod +x ./mvnw

# Construir el proyecto sin correr tests
RUN ./mvnw clean package -DskipTests

# Usar imagen ligera de OpenJDK para correr la app
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copiar el jar generado desde la etapa build
COPY --from=build /app/target/AppBackTareas-0.0.1-SNAPSHOT.jar app.jar

# Puerto que expondrá la app
EXPOSE 8081

# Comando para iniciar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
