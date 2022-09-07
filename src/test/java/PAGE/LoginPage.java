package PAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    WebDriver driver;
    BasePage basePage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getCredentialsAndLogin() throws InterruptedException{
        basePage = new BasePage(driver);

        List<WebElement> givenLoginsElem = driver.findElements(By.cssSelector("[id='login_credentials']"));
        String savedLoginsStr = givenLoginsElem.get(0).getText();
        String[] loginsStrArray = savedLoginsStr.split("\n");

        basePage.insertInto("css", "[id='user-name']", loginsStrArray[1]);

        List<WebElement> givenPasswordsElem = basePage.getElements("css", "[class='login_password']");
        String savedPasswordsStr = givenPasswordsElem.get(0).getText();
        String[] passwordsStrArray = savedPasswordsStr.split("\n");

        basePage.insertInto("css", "[id='password']", passwordsStrArray[1]);
        basePage.clickOnElement("css", "[id='login-button']");
        basePage.delay(2);
    }
   }

  /*
We take the webelement, assign it to a string because we need to use string type for our login, but as our string
includes all the logins, we split it and place it into Strings array, and then send the string with index[1]
 to the page. */
