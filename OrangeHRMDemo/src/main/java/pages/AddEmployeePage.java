package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {
	private WebDriver driver;

    private By addEmployeeBtn = By.xpath("//a[text()='Add Employee']");
    private By firstNameInput = By.name("firstName");
    private By lastNameInput = By.name("lastName");
    private By createLoginDetailsSwitch = By.xpath("//p[text()='Create Login Details']/../..//input[@type='checkbox']");
    private By usernameInput = By.xpath("//label[text()='Username']/../following-sibling::div/input");
    private By passwordInput = By.xpath("//label[text()='Password']/../following-sibling::div/input");
    private By confirmPasswordInput = By.xpath("//label[text()='Confirm Password']/../following-sibling::div/input");
    private By saveBtn = By.xpath("//button[@type='submit']");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddEmployee() {
        driver.findElement(addEmployeeBtn).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    
    public void enableLoginDetails() {
        //driver.findElement(createLoginDetailsSwitch).click();
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//p[text()='Create Login Details']/../..//span"));
        action.moveToElement(element).click(element).perform();
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(password);
    }

    public void clickSave() {
        driver.findElement(saveBtn).click();
    }

    public void addEmployee(String firstName, String lastName, String username, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enableLoginDetails();
		// Create a WebDriverWait object with a timeout of 10 seconds
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Username']/../following-sibling::div/input")));
        enterUsername(username);
        enterPassword(password);
        clickSave();
    }
}
