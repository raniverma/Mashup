FROM openjdk:10

ADD ./target/registration-service-1.0.3-SNAPSHOT.jar registration-service.jar
EXPOSE 8020

ENTRYPOINT ["java","-jar","registration-service.jar"]
