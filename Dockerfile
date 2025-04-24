FROM openjdk:17
COPY build/libs/car-rental-service.jar car-rental-service.jar
ENTRYPOINT ["java", "-jar", "/car-rental-service.jar"]