package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Elements Decline Button on the landing page cookie pop up
    @FindBy(id = "declineButton")
    WebElement declineCookiesButton;

    // Outlet image element
    @FindBy(id = "contentbean:4925590")
    WebElement outletElm;

    // Input field
    @FindBy(id = "query-header")
    WebElement searchInput;

    // Search button
    @FindBy(css = "[data-testid='search-button']")
    WebElement searchButton;

    // Declining the cookie options
    public void clickDeclineCookies() {
        WebElement banner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coiBannerHeadline")));
        if(banner != null && declineCookiesButton.isDisplayed()){
            declineCookiesButton.click();
        }
    }

    public void clickOutletIcon() {
        outletElm.click();
    }

    public void searchFunction(String searchWord) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("query-header")));
        searchBox.sendKeys(searchWord);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isPresent(String searchWord) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='" + searchWord + "']")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}