# Testvox-Assessment
Assessment Task: End-to-End Test Automation Using UI and API.
--------------------------------------------------------------------------------------
Part 1: Selenium + Java (Main Focus).

Here’s a complete Java Selenium automation framework using TestNG, Page Object Model (POM), and Extent Reports for your OrangeHRM scenario.
📁 Project Structure
src/
 └─ main/
     └─ java/
         ├─ pages/
         │    ├─ LoginPage.java
         │    ├─ DashboardPage.java
         │    ├─ AddEmployeePage.java
         │    └─ EmployeeListPage.java
         └─ utils/
              ├─ DriverFactory.java
              └─ ExtentReportManager.java
 └─ test/
     └─ java/
         └─ tests/
             └─ AddEmployeeTest.java
testng.xml

1. pom.xml dependencies
2. Driver Factory Utility
3. Extent Report Utility
4. POM Classes
a) LoginPage
b) DashboardPage
c) AddEmployeePage
d) EmployeeListPage
5. Test Class
6. TestNG XML

How to Run
Place all files into appropriate directories as above.
Run mvn test or launch via your IDE using testng.xml.
See test report at ./test-output/extent.html.
Note:
For production, replace Thread.sleep() with WebDriverWait for robustness.
This framework is extendable for more tests and page objects.
