# Maven image with Java 17
FROM maven:3.9-eclipse-temurin-17

# Working directory inside the container
WORKDIR /app

# Persist Maven/TestNG test results
VOLUME ["/app/target"]

# Copy Maven configuration first
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy TestNG suite
COPY testng.xml .

# Copy test source code
COPY src ./src

# Run TestNG tests when container starts .
CMD ["mvn", "test", "-DsuiteXmlFile=testng.xml"]