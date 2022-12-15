#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY docker-data/application.properties /home/app/src/main/resources
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/DiscoveryServer-0.0.1-SNAPSHOT.jar /usr/local/lib/DiscoveryServer.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/usr/local/lib/DiscoveryServer.jar"]