package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	private WebDriver driver;

    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By logoutDropdown = By.cssSelector(".oxd-userdropdown-name");
    private By logoutLink = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPIM() {
        driver.findElement(pimMenu).click();
    }

    public void logout() {
        driver.findElement(logoutDropdown).click();
        driver.findElement(logoutLink).click();
    }
}
