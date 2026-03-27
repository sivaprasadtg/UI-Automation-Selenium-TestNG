package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.LoginPage;


public class FeatureTests extends BaseTest {

    @Test(
            testName = "Search Functionality Test",
            description = "Verify that the search feature returns relevant results for a given query."
    )
    public void testSearchFunction() {
        LandingPage lPage = new LandingPage(driver);
        String searchString = "Laptop";
        lPage.clickDeclineCookies();

        lPage.searchFunction(searchString);

        lPage.clickSearchButton();

        Assert.assertTrue(lPage.isPresent(searchString), "Search results does not match");
    }

    @Test(
            testName = "Login Page Elements Test",
            description = "Verify that the login page consists of required elements."
    )
    public void testLoginPageElements() throws InterruptedException {
        LandingPage lPage = new LandingPage(driver);
        LoginPage loPage = new LoginPage(driver);

        lPage.clickDeclineCookies();

        loPage.clickLoginMenuIcon();
        Assert.assertTrue(loPage.loginPageElementsPresent(), "Element(s) on login page is/are missing.");
        loPage.waitForPageLoadComplete();
        Assert.assertTrue(loPage.isLoginButtonDisabled(), "Login button is enabled without entering user credentials.");
    }

    @Test(
            testName = "Add to Cart Test",
            description = "Verify that the product from outlet page can be added to cart."
    )
    public void testAddProductToCartFromOutlet() {

        LandingPage lPage = new LandingPage(driver);
        lPage.clickDeclineCookies();
        lPage.clickOutletIcon();


    }

}
