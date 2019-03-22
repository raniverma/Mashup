FROM openjdk:10

ADD ./target/score-badge-service-1.0.3-SNAPSHOT.jar score-badge-service.jar
EXPOSE 8027

ENTRYPOINT ["java","-jar","score-badge-service.jar"]
