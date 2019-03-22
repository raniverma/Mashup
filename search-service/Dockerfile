FROM openjdk:10

ADD ./target/search-service-1.0.3-SNAPSHOT.jar search-service.jar
EXPOSE 8026

ENTRYPOINT ["java","-jar","search-service.jar"]
