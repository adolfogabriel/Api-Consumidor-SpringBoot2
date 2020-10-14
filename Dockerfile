FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/Api-Consumidor-1.0-SNAPSHOT.jar api-consumidor.jar
EXPOSE 9090
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "api-consumidor.jar"]
