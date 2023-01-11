FROM amazoncorretto:17-alpine-jdk

MAINTAINER tunombre_o_alias

COPY target/portfolio3-0.0.1-SNAPSHOT.jar portfolio3-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/portfolio3-0.0.1-SNAPSHOT.jar"]