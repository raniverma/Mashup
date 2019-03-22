FROM openjdk:10
FROM maven:3.6.0-jdk-10
#FROM codilogy/nodemon:latest
#FROM node:8.11.2-alpine
#RUN npm install -g nodemon

ADD ./target/execution-engine-1.0.3-SNAPSHOT.jar execution-engine.jar
EXPOSE 8025

ENTRYPOINT ["java","-jar","execution-engine.jar"]
