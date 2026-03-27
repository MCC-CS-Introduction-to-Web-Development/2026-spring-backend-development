FROM eclipse-temurin:17
WORKDIR /app
COPY build/libs/2026-spring-back-end-1.0-SNAPSHOT.jar demo.jar
EXPOSE 8080
CMD ["java", "-jar", "demo.jar"]