FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8083
ARG JAR_FILE=target/sampleapp-kubemq-1.0-SNAPSHOT.jar
COPY ${JAR_FILE} sampleapp-kubemq.jar
ENTRYPOINT ["java","-jar","sampleapp-kubemq.jar"]