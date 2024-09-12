# Use the official OpenJDK image from the Alpine Linux distribution
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the target directory to the container
COPY target/bookstore-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
