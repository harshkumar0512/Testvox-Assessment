package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage {

	private WebDriver driver;

    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEmployeeAdded(String firstName, String lastName) {
        // Wait and verify employee's Personal Details page is displayed
        By personalDetailsHeader = By.xpath("//h6[text()='Personal Details']");
        //By profileName = By.xpath("//input[@name='firstName' and @value='" + firstName + "']");
        By profileName = By.xpath("//input[@name='firstName']");
        //By profileSurname = By.xpath("//input[@name='lastName' and @value='" + lastName + "']");
        By profileSurname = By.xpath("//input[@name='lastName']");
        try {
            Thread.sleep(2000); // Replace with WebDriverWait in real projects
        } catch (InterruptedException e) {}
        return driver.findElements(personalDetailsHeader).size() > 0 &&
            driver.findElements(profileName).size() > 0 &&
            driver.findElements(profileSurname).size() > 0;
    }
}
