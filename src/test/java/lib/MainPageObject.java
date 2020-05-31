package lib;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yecht.Data;


import java.text.ParseException;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
public class MainPageObject extends CoreTestCase {

    // ожидание элемена
    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(presenceOfElementLocated(by));
    }

    public void visitPage(String baseUrl) {
        driver.get(baseUrl);
        return;
    }

    // клик после нахождения лемента
    public WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }
    // ввод после нахождения элемента
    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public WebElement waitForElementAndBecomeEnabled(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.isEnabled();
        return element;
    }

    public void presenceOfElementLocatedBy(By by, String error_message) {
        Assert.assertNotNull(error_message, presenceOfElementLocated(by));
        return;
    }

    public WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    public String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeOutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        return element.getAttribute(attribute);
    }

    public WebElement waitForElementAndCheckSelected(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.isSelected();
        return element;
    }
    public String getCurrentUnixtime(){
        Long current_date;
        current_date = System.currentTimeMillis() / 1000L;
        String unix_current_date = current_date.toString();
        return unix_current_date;
    }

    public String createUniqEmail(){
       String email = "test+"+getCurrentUnixtime()+"@mail.ru";
       return  email;
    }

}


