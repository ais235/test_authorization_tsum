package lib;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class PageHomeLogin extends MainPageObject {

    private static final String
            AUTHORISATION = "//p[@class='auth-layout__control-button first active'][contains(.,'Авторизация')]",
            REGBATTON_CHECK = "//p[@class='auth-layout__control-button last active'][contains(.,'Регистрация')]",
            EMAIL = "//input[@placeholder='Email']",
            PASSWORD = "//input[@placeholder='Пароль']",
            REG_TAB = "//p[@preservequeryparams][contains(.,'Регистрация')]",
            REGBATTON = "(//button[@type='submit'])[1]",
            REG_SACCESS = "//*[contains(.,'Успешная регистрация')]",
            INVALID_EMAIL = "//span[contains(.,'Указан некорректный email')]",
    //            INVALID_PASSWORD = format("//span[contains(.,'%s')]", +invalidPassword),
            RULES_SALES = "//a[contains(.,'Правила продажи товаров')]";

    @Step("Check: the auth form is active")
    public void checkAuthActive()
    {
        this.waitForElementPresent(
                By.xpath(AUTHORISATION),
                "Не найден локатор: "+ AUTHORISATION,
                5
        );

    }
    @Step("Пеерход на форму регистрации")
    public void clickRegBatton()
    {
        this.waitForElementAndClick(
                By.xpath(REG_TAB),
                "Не найден локатор: "+ REG_TAB,
                5
        );
        this.waitForElementPresent(
                By.xpath(REGBATTON_CHECK),
                "Не найден локатор: "+ REGBATTON_CHECK,
                5
        );
    }
    @Step("Заполнение кредов: емейл")
    public void fillEmail(String email)    {
        this.waitForElementAndSendKeys(
                By.xpath(EMAIL),
                email,
                "Не найден локатор: "+EMAIL,
                5
        );
    }
    @Step("Заполнение кредов: пароль")
    public void fillPassword(String password)    {
        this.waitForElementAndSendKeys(
                By.xpath(PASSWORD),
                password,
                "Не найден локатор: "+PASSWORD,
                5
        );
    }
    @Step("Проверка наличия ссылки Правила продажи товаров")
    public void rulesSale() {
        this.waitForElementPresent(
                By.xpath(RULES_SALES),
                "Не найден локатор: " + RULES_SALES,
                5
        );
    }
    @Step("Подтверждение ввода данных")
    public void clickBattonForRegInput() {
        this.waitForElementAndClick(
                By.xpath(REGBATTON),
                "Не найден локатор: " + REGBATTON,
                5
        );
    }
    @Step("Проверка успешности регистрации")
    public void regSaccess() {
        this.waitForElementPresent(
                By.xpath(REG_SACCESS),
                "Не найден локатор: " + REG_SACCESS,
                5
        );
    }
    @Step("Ввод некорректного емейла")
    public void regInvalidMail() {
        this.waitForElementPresent(
                By.xpath(INVALID_EMAIL),
                "Не найден локатор: " + INVALID_EMAIL,
                5
        );
    }
    @Step("Ввод некорректного пароля")
    public void regInvalidPasword(String invalidPassword) {
        this.waitForElementPresent(
                By.xpath(String.format("//span[contains(.,'%s')]", invalidPassword)),
                "Не найден локатор: ",
                5
        );
    }
    @Step("Проверка успешности авториазации")
    public void checkMail(String Mail) {
        this.waitForElementPresent(
                By.xpath(String.format("//a[contains(.,'%s')]", Mail)),
                "Не найден локатор: ",
                5
        );
    }
    @Step("Отображение ошибки при вводе некорректного пароля")
    public void wrongLoginOrPassword(String LogPass) {
        this.waitForElementPresent(
                By.xpath(String.format("//span[contains(.,'%s')]", LogPass)),
                "Не найден локатор: ",
                5
        );
    }



}
