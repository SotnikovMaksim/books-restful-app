FROM openjdk:17

WORKDIR .

COPY build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
