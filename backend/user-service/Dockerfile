FROM openjdk:17-jdk-alpine
MAINTAINER dinesh-more
WORKDIR /opt
COPY target/*.jar /opt/app.jar
#ENTRYPOINT ["java","-jar","/opt/app.jar"]
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar