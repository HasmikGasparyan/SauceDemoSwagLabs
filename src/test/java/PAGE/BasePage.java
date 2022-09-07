package PAGE;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method returns the Selenium By type.
     *
     * @param locatorType
     * @param locator
     * @return
     */
    public By getByType(String locatorType, String locator) {
        if (locatorType.toLowerCase(Locale.ROOT).equals("css")) {
            return By.cssSelector(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("xpath")) {
            return By.xpath(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("id")) {
            return By.id(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("name")) {
            return By.name(locator);
        } else {
            return By.tagName("");
        }
    }

    public WebElement getElement(String locatorType, String locator) {
        By byType = getByType(locatorType, locator);
        WebElement elem = driver.findElement(byType);
        return elem;
    }

    public Select selectElement(String locatorType, String locator, String value) {
        By byType = getByType(locatorType, locator);
        WebElement elem = driver.findElement(byType);
        Select element = new Select(elem);
        element.selectByValue(value);
        return element;
    }


    public List<WebElement> getElements(String locatorType, String locator){
        By byType = getByType(locatorType, locator);
        List<WebElement> elems = driver.findElements(byType);
        return elems;
    }

    public void clickOnElement(String locatorType, String locator){
        By byType = getByType(locatorType, locator);
        driver.findElement(byType).click();
    }

    public void insertInto(String locatorType, String locator, String text){
        WebElement elem = getElement(locatorType, locator);
        elem.clear();
        elem.sendKeys(text);
    }

    /**
     * Use this method to check the web page title
     *
     * @param expectedTitle
     */

    public void checkPageTitle(String expectedTitle) {
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }


    /**
     * The method to implement customs wait
     *
     * @param locator
     * @return
     */
    public boolean customTry(String locatorType, String locator) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 5) {
            try {
                driver.findElement(getByType(locatorType, locator)).click();
                result = true;
                break;
            } catch (Exception e) {
            }
            attempts++;
        }
        return result;
    }

    /**
     * Use this method to go to web page menu item by locator and text
     *
     * @param itemText
     * @param locator
     */
    public void goToMenuItem(String itemText, String locatorType, String locator) {
        if (customTry(locatorType, locator)) {
            List<WebElement> items = getElements(locatorType, locator);
            boolean isItemExist = false;
            for (WebElement item : items) {
                if (item.getText().equals(itemText)) {
                    item.click();
                    isItemExist = true;
                    break;
                }
            }
            Assert.assertTrue(isItemExist);
        }
    }

    /**
     * Use this method to set delay by seconds between steps.
     * @param seconds
     * @throws InterruptedException
     */
    public void delay(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    /**
     * Use this method to set explicitly wait.
     * @param conditions
     */
    public void exlicitlyWait(Function conditions){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(conditions);
    }
    public void checkElemetText(String locatorType, String locator, String expectedText){
        WebElement elem = getElement(locatorType, locator);
        String actualText = elem.getText();
        Assert.assertEquals(actualText, expectedText, "The expected text from element not mutch");
    }

    public void getUrl(String URL){
        driver.get(URL);
    }
    public String setUrl(){
        return  driver.getCurrentUrl();

    }
    public void verifyMenuItemText(String itemText, String locatorType, String locator) {
        if (customTry(locatorType, locator)) {
            List<WebElement> items = getElements(locatorType, locator);
            boolean isItemExist = false;
            for (WebElement item : items) {
                if (item.getText().equals(itemText)) {
                    isItemExist = true;
                    Assert.assertTrue(isItemExist);
                    break;
                }
            }
            Assert.assertTrue(isItemExist);
        }
    }

    //==================================================

   /* public List<WebElement> getElementText(String locatorType, String locator){
        By byType = getByType(locatorType, locator);
        List<WebElement> elems = driver.findElements(byType);
        System.out.println(elems.);
        return elems;
    }*/






}
