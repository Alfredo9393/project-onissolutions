FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8082
ARG JAR_FILE=target/receive-kubemq-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} receive-kubemq.jar
ENTRYPOINT ["java","-jar","receive-kubemq.jar"]