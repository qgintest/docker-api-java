# RestAssured API Test Project

A simple Java API automation project using **RestAssured**, **TestNG**, and **Maven**. This project is also used to practice running automated tests inside **Docker containers**.

## Technologies

- Java
- RestAssured
- TestNG
- Maven
- Docker

## Project Structure

```text
restassured-api-tests/
├── pom.xml
├── testng.xml
├── Dockerfile
└── src/
    └── test/
        └── java/
            └── tests/
                └── UserApiTests.java
```

## API Tests

The sample test suite contains basic REST API tests covering:

- GET — Retrieve a user
- POST — Create a user
- PUT — Update a user
- DELETE — Delete a user

## Run Tests with Maven

Run the default test suite:

```bash
mvn test
```

Pass a TestNG XML suite dynamically:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

For a suite stored in another directory:

```bash
mvn test -DsuiteXmlFile=src/test/resources/testsuite.xml
```

## TestNG Suite

Example `testng.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="API Test Suite">

    <test name="RestAssured API Tests">
        <classes>
            <class name="tests.UserApiTests"/>
        </classes>
    </test>

</suite>
```

## Maven Surefire Configuration

The project uses Maven Surefire to execute the TestNG suite.

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.5.4</version>

    <configuration>
        <suiteXmlFiles>
            <suiteXmlFile>${suiteXmlFile}</suiteXmlFile>
        </suiteXmlFiles>
    </configuration>
</plugin>
```

## Docker

The project can be containerized so the API tests execute in a consistent environment without requiring Java or Maven to be installed directly on the host machine.

Build the Docker image:

```bash
docker build -t restassured-tests .
```

Run the tests:

```bash
docker run --rm restassured-tests
```

Run the tests make test results visible locally, make sure DockerFile has Volume mapped:

```bash
docker run -v ./test-results:/app/target aeendale/apijavaimage
```


## Purpose

This is a lightweight sample project for experimenting with:

- Running Java automated tests with Maven
- Executing TestNG suites
- RestAssured API testing
- Maven dependency management
- Docker image creation
- Running automated tests inside Docker containers