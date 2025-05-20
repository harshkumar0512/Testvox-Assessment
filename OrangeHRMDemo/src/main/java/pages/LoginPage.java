package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void login(String username, String password) throws InterruptedException {
        enterUsername(username);
        enterPassword(password);
        Thread.sleep(1000);
        clickLogin();
    }

}
