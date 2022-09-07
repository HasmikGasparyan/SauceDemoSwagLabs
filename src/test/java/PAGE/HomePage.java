package PAGE;

import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    BasePage basePage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // we take the locator of dropdown and the text value of the needed filter option
    public void setFilter() throws InterruptedException{
        basePage = new BasePage(driver);
        basePage.selectElement("css", "[data-test='product_sort_container']", "lohi");
        basePage.delay(2);
    }

    public void addToCard() throws InterruptedException{
        basePage = new BasePage(driver);
        basePage.clickOnElement("css", "[id='add-to-cart-sauce-labs-fleece-jacket']");
        basePage.clickOnElement("css", "[id='shopping_cart_container']");
        basePage.delay(2);

    }
}
