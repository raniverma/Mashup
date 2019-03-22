FROM openjdk:10

ADD ./target/recommendation-service-1.0.3-SNAPSHOT.jar recommendation-service.jar
EXPOSE 8023

ENTRYPOINT ["java","-jar","recommendation-service.jar"]
