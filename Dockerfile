# Define base Docker image
FROM openjdk:17
LABEL maintainer="secdemo.net"
ADD target/Spring_soap_ws_App-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
