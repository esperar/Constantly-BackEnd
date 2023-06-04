FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/constant.jar constant.jar
EXPOSE 8080
CMD ["java", "-jar", "constant.jar"]