import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.MainPageObject;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    MainPageObject mainPageObject;

    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofDays(5));
        mainPageObject = MainPageObject.getIntance(webDriver);
    }

    @AfterTest
    public void afterTest() {
        webDriver.quit();
    }

}
