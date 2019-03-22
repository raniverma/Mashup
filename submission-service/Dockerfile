FROM openjdk:10

ADD ./target/submission-service-1.0.3-SNAPSHOT.jar submission-service.jar
EXPOSE 8029

ENTRYPOINT ["java","-jar","submission-service.jar"]
