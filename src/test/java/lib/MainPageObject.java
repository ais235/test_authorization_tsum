package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    // получение текущеей даты
    public String getCurrentUnixtime(){
        Long current_date;
        current_date = System.currentTimeMillis() / 1000L;
        String unix_current_date = current_date.toString();
        return unix_current_date;
    }
    // создание почты
    public String createUniqEmail(){
       String email = "test+"+getCurrentUnixtime()+"@mail.ru";
       return  email;
    }
}


