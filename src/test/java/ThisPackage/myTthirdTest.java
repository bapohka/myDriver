package ThisPackage;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by bapoh on 13.07.2017.
 */
public class myTthirdTest {

    WebDriver driver2; //объявляем в классе, чтобы драйвер был доступен в любом методе

    @BeforeTest //выносим до теста, тк объявить вебдрайвер нужно лишь один раз
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "webDriver_Chrome/chromedriver.exe");
        driver2 = new ChromeDriver();

        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //задаем между действиями таймаут 10 секунд неявного ожидания, при этом каждые 2 секунды идет проверка элемента
        /**
         * manage позволяет задавать разные свойства вебдрайверу
         */
        //driver2.findElement(By.cssSelector("123")); // поиск по css элемента
    }

    boolean doesElementExists(String selector) {
        try {
            driver2.findElement(By.cssSelector(selector));
        return true;
        }
        catch (ElementNotFoundException e) {
            return false;
        }
    }
    @Test(priority = 1)
    void thirdTest() {
        driver2.get("www.google.com");
        Assert.assertTrue(doesElementExists("mySelector")); //булеан штука, которая говорит нам - есть чо?
        Assert.assertTrue(driver2.getTitle() == "fdsfs"); //проверка, что мы на нужном тайтле
    }


@AfterTest //в конце после тестов завершаем процесс
        void tearDown(){
        driver2.quit();
    }
}
