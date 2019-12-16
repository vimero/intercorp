FROM maven:3.5.2-jdk-8-alpine AS maven_build

COPY pom.xml /tmp/

COPY src /tmp/src/

WORKDIR /tmp/

RUN mvn package

FROM openjdk:8-jdk-alpine

MAINTAINER rony@vimero.io

EXPOSE 8080

CMD java -jar /data/intercorp-ms-1.0.0.jar

COPY --from=maven_build /tmp/target/intercorp-ms-1.0.0.jar /data/intercorp-ms-1.0.0.jar