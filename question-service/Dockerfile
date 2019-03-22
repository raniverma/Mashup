FROM openjdk:10

ADD ./target/question-service-1.0.3-SNAPSHOT.jar question-service.jar
EXPOSE 8022

ENTRYPOINT ["java","-jar","question-service.jar"]
