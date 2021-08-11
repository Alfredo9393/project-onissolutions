FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/InformationClubWifi-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} informationclubwifi.jar
ENTRYPOINT ["java","-jar","informationclubwifi.jar"]