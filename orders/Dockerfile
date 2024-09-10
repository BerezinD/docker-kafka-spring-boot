FROM ubuntu:22.04 AS build-common
WORKDIR /build

RUN apt update --fix-missing \
    && apt install -y --no-install-recommends openjdk-21-jdk maven curl \
    && apt clean

COPY ./pom.xml /build/pom.xml
COPY ./orders /build/orders

# RUN --mount=type=cache,target=/root/.m2 mvn clean package

WORKDIR /app
RUN cp /build/orders/target/*.jar /app/orders.jar
RUN rm -rf /build

ENTRYPOINT ["java", "-jar",  "/app/orders.jar"]

CMD ["/bin/sh", "-c", "bash"]
