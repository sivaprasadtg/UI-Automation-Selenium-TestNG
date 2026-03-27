package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage  {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(xpath = "//li[.//span[text()='Logga in']]")
    WebElement loginMenu;

    By emailInput = By.id("signInName");

    By passwordInput = By.id("password");

    By loginButton = By.id("next");

    By privateSpanSelection= By.xpath("//span[@class='spanSlidingPrivate' and text()='Privat']");

    By forgotPasswordLink = By.id("forgotPassword");

    // Method to click login menu icon
    public void clickLoginMenuIcon() {
        loginMenu.click();
    }

    // Element present check method
    public boolean isElementsPresent(By by) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Check and return boolean state if all needed elements are present in the login page
    public boolean loginPageElementsPresent() {
        return isElementsPresent(emailInput) && isElementsPresent(passwordInput) && isElementsPresent(loginButton) && isElementsPresent(privateSpanSelection) && isElementsPresent(forgotPasswordLink);
    }

    // Wait for login page to be loaded fully
    public void waitForPageLoadComplete() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    // Verify if login button is enabled without user details added when page loads
    public boolean isLoginButtonDisabled() throws InterruptedException {
        Thread.sleep(5000);  // Will replace with explicit wait

        wait.until(driver -> {
            WebElement loginButtonElm = driver.findElement(loginButton);
            return !loginButtonElm.isEnabled();  // wait until disabled
        });

        // After wait completes, check and return button state
        WebElement loginButtonElm = driver.findElement(loginButton);
        return !loginButtonElm.isEnabled();
    }

}
