# Workmarket Take Home Test

This is a take home test for Workmarket. This repo contains a test automation framework utilizing Page Object Model design pattern.

# Directory Structure

```
workmarket-tht/
    |
    |-- src/
         |
         |-- main/java/com/workmarket/test/qe
                |
                |-- BasePage.java
                |-- LandingPage.java
                |-- RegistrationLandingPage.java
                |-- LoginPage.java
                |-- HomePage.java
                |-- SearchPageContainer.java
    |-- test/
         |
         |-- test/java/com/workmarket/test/qe
                |
                |-- TestBase.java
                |-- LandingPageTest.java
                |-- HomePageTest.java
    |
    |-- target/ (ignored)
    |-- .gitignore
    |-- pom.xml
    |-- README.md
```
# Prerequisites

* Java 1.8
* Maven 3.5.4
* VS Code or Eclipse or Intellij or any other Java supported IDE (Used VS Code)

Other dependencies are in the `pom.xml` file, such as selenium, junit, etc.

# Running Tests

## From command line

* Clone or download the repo
* Navigate to `workmarket-tht` directory
* Build the project
```
mvn clean install -DskipTests
```
* Run all tests
```
mvn test
```

* Run all tests
```
mvn test
```
* Run specfic tests in a class
```
mvn -Dtest=HomePageTest test
```

* Run tests to generate surefire report
```
mvn clean install test surefire-report:report
```

Tests were run using ChromeDriver on Chrome 71.0.3578.98

# Notes

There was an issue observed when running one of the tests is that accounts with password that has no number was getting created even though the placeholder mentioned that atleast 1 number/digit should be part of password. So that test fails.
