FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=dians_project-0.0.1-SNAPSHOT.jar
COPY target/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]