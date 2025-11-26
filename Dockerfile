FROM openjdk:17-slim

WORKDIR /app

COPY target/simple-calculator-1.0-SNAPSHOT.jar app.jar

CMD ["java", "-cp", "app.jar", "Calculator", "add", "1", "2"]
