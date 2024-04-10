FROM openjdk:17

WORKDIR /app

COPY target/ClinicaVet-0.0.1-SNAPSHOT.jar /app/ClinicaVet.jar

ENTRYPOINT ["java", "-jar", "ClinicaVet.jar"]