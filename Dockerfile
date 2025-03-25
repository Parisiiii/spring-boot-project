FROM gradle:8.12.1-jdk23

RUN apt -y update && \
    apt -y install netcat-openbsd && \
    apt -y upgrade

WORKDIR /spring-api

COPY src /spring-api/src
COPY build.gradle.kts /spring-api
COPY .gradle /spring-api
COPY gradle /spring-api
COPY gradlew.bat /spring-api
COPY gradlew /spring-api

RUN gradle wrapper && \
    ./gradlew clean build

COPY build/libs/alura-curso-0.0.1-SNAPSHOT.jar /aplicacao.jar

COPY database/startup.sh /spring-api/startup.sh
RUN chmod +x /spring-api/startup.sh

EXPOSE 8080
ENTRYPOINT ["./startup.sh"]
