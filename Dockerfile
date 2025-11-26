FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy packaged jar
COPY target/simple-calculator-1.0-SNAPSHOT.jar app.jar

# default command: runs add 1 2 (change via docker run cmd)
CMD ["java", "-cp", "app.jar", "Calculator", "add", "1", "2"]
