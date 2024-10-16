# Use a lightweight OpenJDK image for running the app
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the pre-built jar file from your local environment or CI pipeline
COPY target/calculator-app-0.0.1-SNAPSHOT.jar ./calculator-app-0.0.1-SNAPSHOT.jar

# Expose the port your application will run on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "calculator-app-0.0.1-SNAPSHOT.jar"]

