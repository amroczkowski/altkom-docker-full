FROM openjdk:11-jdk-oracle
ARG JAR_FILE=target/*jar
COPY ${JAR_FILE} /app.jar
COPY config/application-dev.yml /application.yml
RUN mkdir /pictures
VOLUME /pictures
ENTRYPOINT ["java", "-jar", "/app.jar"]