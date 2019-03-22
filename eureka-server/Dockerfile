FROM openjdk:10

ADD ./target/eureka-server-1.0.3-SNAPSHOT.jar  /event/src/eureka-server-1.0.3-SNAPSHOT.jar
EXPOSE 8093
WORKDIR event/src
ENTRYPOINT ["java","-jar","eureka-server-1.0.3-SNAPSHOT.jar"]
