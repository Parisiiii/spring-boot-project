FROM gradle:8.12.1-jdk23

RUN apt -y update && \
    apt -y upgrade

WORKDIR /alura

COPY src /alura/src
COPY build.gradle.kts /alura
COPY .gradle /alura

RUN gradle build

COPY /build/libs/alura-curso-0.0.1-SNAPSHOT.jar /aplicacao.jar

EXPOSE 1212
ENTRYPOINT ["java", "-XX:+UseContainerSupport","-jar", "/aplicacao.jar"]
