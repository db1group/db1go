# DB1 GO - CM

## Build

### Option A

This Dockerfile is used in order to build a container that runs the Quarkus application in JVM mode. Before building the docker image run:

`mvn package`

Then, build the image with:

`docker build -f src/main/docker/Dockerfile.jvm -t quarkus/newbietrader-api-jvm .`

Then, run the container using:

`docker run -i --rm -p 8080:8080 quarkus/newbietrader-api-jvm`

### Option B

This Dockerfile is used in order to build a container that runs the Quarkus application in native (no JVM) mode. Before building the docker image run:

`mvn package -Pnative -Dnative-image.docker-build=true`

Then, build the image with:

`docker build -f src/main/docker/Dockerfile.native -t quarkus/newbietrader-api .`

Then, run the container using:

`docker run -i --rm -p 8080:8080 quarkus/newbietrader-api`

## Deploy

Pré requirements

* Google Account
* Project with name `cm-newbie-trader`