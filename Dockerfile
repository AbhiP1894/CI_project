FROM eclipse-temurin:17
LABEL mentainer="javaguides.net@gmail.com"
WORKDIR /app
COPY target/JacocoExample-1.1.jar /app/JacocoExample-1.1.jar
ENTRYPOINT ["java", "-jar", "JacocoExample-1.1.jar"]

