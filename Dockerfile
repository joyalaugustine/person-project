FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} person-project.jar
ENTRYPOINT ["java","-jar","/person-project.jar"]