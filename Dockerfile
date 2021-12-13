FROM openjdk:11-jre-slim
RUN apt-get update && apt-get -y upgrade && apt clean all
ADD target/demo-0.0.1-SNAPSHOT.jar app.jar
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
ENTRYPOINT ["/bin/sh","-c","java -jar /app.jar"]
