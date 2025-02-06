FROM eclipse-temurin:17
LABEL mentainer="javaguides.net@gmail.com"
WORKDIR /app
COPY target/JacocoExample-0.0.1-SNAPSHOT.jar /app/JacocoExample-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "JacocoExample-0.0.1-SNAPSHOT.jar"]
