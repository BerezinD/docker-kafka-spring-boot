FROM ubuntu:22.04 AS build-common
WORKDIR /build

RUN apt update --fix-missing \
    && apt install -y --no-install-recommends openjdk-21-jdk maven curl \
    && apt clean

COPY ./pom.xml /build/pom.xml
COPY ./user-api /build/user-api

# RUN --mount=type=cache,target=/root/.m2 mvn clean package

WORKDIR /app
RUN cp /build/user-api/target/*.jar /app/user-api.jar
RUN rm -rf /build

ENTRYPOINT ["java", "-jar",  "/app/user-api.jar"]

CMD ["/bin/sh", "-c", "bash"]
