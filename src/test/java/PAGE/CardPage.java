package PAGE;

import org.openqa.selenium.WebDriver;

public class CardPage {
    WebDriver driver;
    BasePage basePage;

    public CardPage (WebDriver driver) {
        this.driver = driver;
    }

    public void checkoutAndFinish(String name, String lastName, String postalCode) throws InterruptedException{
        basePage = new BasePage(driver);
        basePage.checkElemetText("css", "[class='inventory_item_name']", "Sauce Labs Fleece Jacket");
        basePage.checkElemetText("css", "[class='inventory_item_price']", "$49.99");
        basePage.clickOnElement("css", "[id='checkout']");
        basePage.delay(2);
        basePage.insertInto("css", "[id='first-name']", name);
        basePage.insertInto("css", "[id='last-name']", lastName);
        basePage.insertInto("css", "[id='postal-code']", postalCode);
        basePage.clickOnElement("css", "[id='continue']");
        basePage.delay(2);
        basePage.clickOnElement("css", "[id='finish']");
    }
}
