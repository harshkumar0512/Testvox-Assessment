package tests;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.ExtentReportManager;

public class AddEmployeeTest {

	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;

	private final String baseUrl = "https://opensource-demo.orangehrmlive.com/";

	@BeforeClass
	public void setupReport() {
		extent = ExtentReportManager.getInstance();
	}

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get(baseUrl);
	}

	@Test
	public void testAddEmployee() {
		test = extent.createTest("Add New Employee Test");

		try {
			// 1. Login as Admin
			LoginPage loginPage = new LoginPage(driver);

			System.out.println("Wait for page to load.");

			// Implicit Wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			// Create a WebDriverWait object with a timeout of 10 seconds
			// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait for the element to be visible
			// WebElement element =
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

			loginPage.login("Admin", "admin123");
			System.out.println("1. Logged in as Admin.");
			test.info("Logged in as Admin");

			// 2. Navigate to PIM > Add Employee
			DashboardPage dashboard = new DashboardPage(driver);
			dashboard.goToPIM();
			System.out.println("2.a. Navigated to PIM");
			test.info("Navigated to PIM");

			AddEmployeePage addEmployee = new AddEmployeePage(driver);
			addEmployee.clickAddEmployee();
			System.out.println("2.b. Clicked Add Employee.");
			test.info("Clicked Add Employee");

			// 3. Fill employee details
			String firstName = "John";
			String lastName = "Doe";
			String uniqueUsername = "john" + UUID.randomUUID().toString().substring(0, 6);
			String password = "Test@1234";
			addEmployee.addEmployee(firstName, lastName, uniqueUsername, password);
			System.out.println("3. Employee details filled and saved.");
			test.info("Employee details filled and saved");

			// 4. Verify employee added
			EmployeeListPage employeeList = new EmployeeListPage(driver);
			Assert.assertTrue(employeeList.isEmployeeAdded(firstName, lastName),
					"Employee should be added successfully.");
			System.out.println("4. Employee added successfully!");
			test.pass("Employee added successfully!");

			// 5. Logout
			dashboard.logout();
			System.out.println("5. Logged out!");
			test.info("Logged out");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

	@AfterClass
	public void flushReport() {
		extent.flush();
	}

}
