import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstSeleniumTest {
    WebDriver webDriver;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofDays(5));
    }

    @Test
    public void firstTest(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        By origin = By.xpath("//input[@id='origin']");
        By where = By.xpath("//input[@id='destination']");
        By noWay = By.xpath("//div[@data-test-id='card-text']/p");
        By button = By.xpath("//div[@class='avia-form__submit']//button[@type='submit']");

        webDriver.get("https://www.aviasales.by/");

        webDriver.findElement(origin).sendKeys("Минск");
        webDriver.findElement(where).sendKeys("Мальта");
        webDriver.findElement(button).click();

       wait.until(ExpectedConditions.presenceOfElementLocated(noWay));

       Assert.assertEquals(webDriver.findElement(noWay).getText(), "Нет прямых рейсов");
    }

    @AfterTest
    public void afterTest() {
        webDriver.quit();
    }
}
