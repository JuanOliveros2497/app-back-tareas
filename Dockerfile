FROM openjdk:21-jdk-slim

WORKDIR /app

COPY . .

RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Usa una imagen ligera de Java para producción
FROM openjdk:21-jre-slim

WORKDIR /app

COPY --from=0 /app/target/AppBackTareas-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
