FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/send-kubemq-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} send-kubemq.jar
ENTRYPOINT ["java","-jar","send-kubemq.jar"]