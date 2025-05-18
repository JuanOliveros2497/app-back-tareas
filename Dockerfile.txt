# Usa una imagen oficial de Java con Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Usa una imagen ligera de Java para producción
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/AppBackTareas-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]