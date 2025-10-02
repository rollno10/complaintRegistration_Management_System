# Stage1: build the jar with Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /workspace

# Copy only maven fies first for caching
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

#Download dependencies (speeds up rebuilds)
RUN mvn -B dependency:go-offline

#Copy source and build jar
COPY src ./src
RUN mvn -B -DskipTests package

#Stage 2: runtime image (smaller, only JRE/JDK)
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the produced jar (wildcard handles the actual jar name)
COPY --from=build /workspace/target/*.jar app.jar

# Expose port your Spring Boot app listens on
EXPOSE 8080

# Optional: allow passing JAVA_OPTS when running
ENV JAVA_OPTS=""

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]