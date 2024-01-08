FROM openjdk:17-jdk-slim

MAINTAINER romeojerenyama@gmail.com

COPY target/drones.jar drones.jar

ENTRYPOINT ["java", "-jar", "drones.jar"]