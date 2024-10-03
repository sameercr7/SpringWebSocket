# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/hello1-0.0.1-SNAPSHOT.jar /app/hello1.jar

# Expose the port that the application runs on
EXPOSE 9090

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/hello1.jar"]