# Etapa 1: Usar imagem Maven para compilar a aplicação
FROM maven:3.8.4-openjdk-11 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Usar a imagem do OpenJDK para rodar a aplicação
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=builder /app/target/simplespdv-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
