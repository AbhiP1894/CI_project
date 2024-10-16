# Use a lightweight OpenJDK image for running the app
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the pre-built jar file from your local environment or CI pipeline
COPY target/calculator-app.jar ./calculator-app.jar

# Expose the port your application will run on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "calculator-app.jar"]

