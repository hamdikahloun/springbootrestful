FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
MAINTAINER Hamdi Kahloun
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api-0.0.1-SNAPSHOT.jar"]
