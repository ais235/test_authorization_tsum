package test;

import lib.CoreTestCase;
import lib.MainPageObject;
import lib.PageHomeLogin;
import lib.PageHomeTsum;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)

public class TsumReg extends CoreTestCase {

    private static final String
            URL_HOME = "https://www.tsum.ru/",
            URL_REG = "https://www.tsum.ru/login/?backurl=%2F";

    MainPageObject mainPage = new MainPageObject();
    public String email=mainPage.createUniqEmail();

    @Steps
    PageHomeLogin pageHomeLogin = new PageHomeLogin();
    PageHomeTsum pageHomeTsum = new PageHomeTsum();

    @Test
    //Регистрация позитивный сценарий

    public void testRegTsumPozitiv()
    {
        System.out.println("Запуск теста");
        pageHomeTsum.visitHomePage(URL_HOME);
        pageHomeTsum.goToLogin();
        pageHomeLogin.checkAuthActive();
        pageHomeLogin.clickRegBatton();
        pageHomeLogin.fillEmail(email);
        pageHomeLogin.fillPassword("password");
        pageHomeLogin.rulesSale();
        pageHomeLogin.clickBattonForRegInput();
        pageHomeLogin.regSaccess();
    }
    @Test
    //Регистрация негативный сценарий указываем некорректный Email и пароль
    public void testRegTsumNegative()
    {
        System.out.println("Запуск теста");
        pageHomeTsum.visitHomePage(URL_HOME);
        pageHomeTsum.goToLogin();
        pageHomeLogin.checkAuthActive();
        pageHomeLogin.clickRegBatton();
        pageHomeLogin.fillEmail("test321mail.ru");
        pageHomeLogin.fillPassword("p");
        pageHomeLogin.rulesSale();
        pageHomeLogin.clickBattonForRegInput();
        pageHomeLogin.regInvalidMail();
        pageHomeLogin.regInvalidPasword("Пароль должен быть не менее 8 символов длиной");
        System.out.println("Тест пройден");
    }
    @Test
    //Вход позитивный сценарий проверка авторизации на сайте tsum
    public void testInputTsumPozitiv()
    {
        System.out.println("Запуск теста");
        pageHomeTsum.visitHomePage(URL_REG);
        pageHomeLogin.checkAuthActive();
        pageHomeLogin.fillEmail("test+1590955171@mail.ru");
        pageHomeLogin.fillPassword("password");
        pageHomeLogin.clickBattonForRegInput();
        pageHomeLogin.checkMail("test+1590955171@mail.ru");
        System.out.println("Тест пройден");
    }
    @Test
    public void testInputTsumNegative()
    {
        System.out.println("Запуск теста");
        pageHomeTsum.visitHomePage(URL_REG);
        pageHomeLogin.checkAuthActive();
        pageHomeLogin.fillEmail("тестовая_почта@почта.рус");
        pageHomeLogin.fillPassword("1");
        pageHomeLogin.clickBattonForRegInput();
        pageHomeLogin.wrongLoginOrPassword("Указан некорректный email");
        System.out.println("Тест пройден");
    }
}
