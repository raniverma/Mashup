FROM openjdk:10

ADD ./target/voting-service-1.0.3-SNAPSHOT.jar voting-service.jar
EXPOSE 8028

ENTRYPOINT ["java","-jar","voting-service.jar"]
