FROM openjdk:17-jdk-slim
LABEL authors="georgeyang"

WORKDIR /app

COPY target/receipt_processor-0.0.1-SNAPSHOT.jar receipt_processor-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "receipt_processor-0.0.1-SNAPSHOT.jar"]