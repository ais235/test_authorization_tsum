package lib;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
public class PageHomeTsum extends MainPageObject {

    private static final String
            LOGIN = "//a[contains(.,'Личный кабинет')][1]";

    @Step("Go to home page")
    public void visitHomePage(String baseUrl) {
        visitPage(baseUrl);
    }

    @Step("Go to uaoth/reg form")
    public void goToLogin()
    {
        this.waitForElementAndClick(
                By.xpath(LOGIN),
                "Не найден локатор для входа в личный кабинет: "+LOGIN,
                5
        );
    }

}