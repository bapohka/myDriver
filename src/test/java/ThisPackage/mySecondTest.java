package ThisPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class mySecondTest{

@Test

    public void testGoogleSearch() {
    System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
    WebDriver driver1 = new ChromeDriver();
        driver1.get("http://www.google.com");
        WebElement searchBox = driver1.findElement(By.name("q"));
        searchBox.sendKeys("webdriver");
        assertEquals("Google", driver1.getTitle());
    driver1.quit();
    }
}
