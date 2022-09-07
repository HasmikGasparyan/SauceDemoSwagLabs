package TEST;

import BASE.SeleniumBase;
import PAGE.*;
import UTILS.Helpers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceDemoTest extends SeleniumBase {
    BasePage basePage;
    MainAddressPage mainAddressPage;
    LoginPage loginPage;
    HomePage homePage;
    CardPage cardPage;
    Helpers helpers;

    String name, lastname, postalCode;

    @BeforeClass
    public void setupDriver() {
        InitDriver();
    }

    @Test()
    public void login() throws InterruptedException {
        basePage = new BasePage(driver);
        mainAddressPage = new MainAddressPage(driver);
        mainAddressPage.getAddress();
        loginPage = new LoginPage(driver);
        loginPage.getCredentialsAndLogin();

    }

    @Test(priority = 1)
    public void filter() throws InterruptedException {
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        homePage.setFilter();
        homePage.addToCard();

    }

    @Test(priority = 2)
    public void checkout() throws InterruptedException {
        basePage = new BasePage(driver);
        cardPage = new CardPage(driver);
        helpers = new Helpers();
        name = helpers.randomFirstName();
        lastname = helpers.randomLastName();
        postalCode = helpers.randomNumber(4);
        cardPage.checkoutAndFinish(name, lastname, postalCode);
        basePage.checkElemetText("css", "[class='title']", "CHECKOUT: COMPLETE!");
    }

   /* @AfterClass
    public void quitDriver(){
        driver.quit();
    }*/
}