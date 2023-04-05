
# API Automation Framework with Rest Assured and JAVA 

Problem Statement: Automating the Location Maps API using Rest Assured and JAVA with BDD Framework.




## Documentation
* [Documentation](https://rest-assured.io/)
* [Predefined Steps](https://www.guru99.com/rest-assured.html)

## Features

- **Maven** structured Framework with cucumber and Rest Assured dependencies
- Implemented **Page Object Model** with Cucumber Framework setup
- Implemented **Feature files** with Test Case you want to automate
- Implemented Smart **Step Defifintion** files with supported code
- Built **Util files** to define all the reusable request and response specifications
- Built **POJO** Classes for **serializing** and **deserializing JSON** PayLoad
- Implement **logging** into Framework to log request and response details.
- Develop End to End Framework Functionality with all **validations and Assertions.**
- Define global properties and drive all global variables from **properties files**
- Define **Enum class** with constants to centralize all the resource details.
- Implement **Data Driven mechanism** to drive all the data dynamically from Feature files.
- Implemented **Parameterization** to run tests with multiple data sets using cucumber example keyword.
- Add more Tests and implement Tagging mechanism to run selected test from **Test Runner** file
- Implemented pre and post condition for Test with **cucumber Hooks**
- Generate **Reports** for Test Execution





## Instructions

- **JDK 1.8+** (make sure Java class path is set)
- **Maven** (make sure .m2 class path is set)
- Plugins for **JUnit, Cucumber, Natural in Eclipse/intelliJ**
- Fork/Clone repository or **download** zip and set it up in your local workspace.
- You can run the test locally simply by pasting the feature tag in **TestRunner.java** file
- Go to your project directory from terminal and hit following commands
```bash
mvn test
mvn test -Dcucumber.options="--tags @Smoke"
mvn test -Dcucumber.options="--tags @VerifyAddPlaceAPI"
mvn test -Dcucumber.options="--tags @VerifyDeletePlaceAPI"
mvn test -Dcucumber.options="--tags @Regression"
```

## To Run on Jenkins
- Provide the project Git source URL or you can downlaod/fork the project directory and give the path while creating the job.
- Select Invoke Top level maven targets under Build section
```bash
test 
test -Dcucumber.options="--tags @VerifyAddPlaceAPI"
test -Dcucumber.options="--tags @VerifyDeletePlaceAPI"
test -Dcucumber.options="--tags @Regression"
```
## Reports

![This is an image](https://user-images.githubusercontent.com/46919369/229980032-113aae51-292e-4191-b12c-746ad0bb7db3.PNG)

## Support

* [LinkedIN](https://www.linkedin.com/in/sailesh-ramesh-96991b13a/)

