#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY docker-data/application.properties /home/app/src/main/resources
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/OrderService-0.0.1-SNAPSHOT.jar /usr/local/lib/OrderService.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/usr/local/lib/OrderService.jar"]