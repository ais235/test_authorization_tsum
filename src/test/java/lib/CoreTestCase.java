package lib;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
/*import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class CoreTestCase extends TestCase {

    protected static WebDriver driver;

    @Before

    public void setUp() throws Exception {
        super.setUp();  // method setUp from junit
        System.setProperty("webdriver.chrome.driver", "F:\\test\\Sasha\\src\\webdriver\\windows\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //растягиваем браузер на весь экран
        driver.manage().window().maximize();

//        //загрузка страницы
//        driver.get("https://yandex.ru");
    }

    @After
    public void tearDown() throws Exception {
        if (driver!=null)
            driver.quit();
        super.tearDown();  // method tearDown from junit
    }

}



