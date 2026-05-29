# Build Stage
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2,id=m2-cache mvn dependency:go-offline

# Copy source code and build
COPY src ./src
RUN --mount=type=cache,target=/root/.m2,id=m2-cache mvn clean package -DskipTests

# Runtime Stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
