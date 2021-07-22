FROM openjdk:8-jdk-alpine
RUN addgroup --system spring && adduser --system spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} forum.jar
ENTRYPOINT ["java","-jar","/forum.jar"]