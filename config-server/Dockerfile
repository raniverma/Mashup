FROM openjdk:10

ADD ./target/config-server-1.0.3-SNAPSHOT.jar /event/src/config-server-1.0.3-SNAPSHOT.jar
EXPOSE 8032
WORKDIR event/src
ENTRYPOINT ["java","-jar","config-server-1.0.3-SNAPSHOT.jar"]