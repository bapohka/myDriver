package ThisPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class myFirstTest {

    @Test
    public void testBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://random.org/integers");
        Thread.sleep(5000);
//        driver.navigate().to("http://random.org");
        WebElement myRandomIntegers = driver.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[1]/input"));
        myRandomIntegers.clear();

        Random myRandom = new Random();
       // int s = myRandom.nextInt(99);
       // String d = toString(s);
        myRandomIntegers.sendKeys("25");
        WebElement myButton = driver.findElement(By.xpath("//*[@id=\"invisible\"]/form/p[5]/input[1]"));
        myButton.click();
        Thread.sleep(2000); //java class замораживает на нужное количество времени
        WebElement resultPage = driver.findElement(By.xpath("//*[@id=\"invisible\"]/pre"));
        String myResult = resultPage.getText();
        System.out.println("your random data now is " + myResult);
        driver.quit();

    }
}