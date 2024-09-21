# Step 1: Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Step 2: Create a working directory for the app
WORKDIR /app

# Step 3: Copy the Maven build file and the application source code
COPY target/todo-backend-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port on which the application will run
EXPOSE 5000

# Step 5: Define environment variables for PostgreSQL (can be overwritten by ECS, Beanstalk, or Docker Compose)
ENV RDS_HOSTNAME=localhost \
    RDS_PORT=5432 \
    RDS_DB_NAME=todo \
    RDS_USERNAME=postgres \
    RDS_PASSWORD=1234

# Step 6: Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]

