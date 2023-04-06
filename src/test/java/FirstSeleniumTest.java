import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.MainPageObject;

import java.time.Duration;

public class FirstSeleniumTest extends BaseTest{
    @Test
    public void firstTest(){
        webDriver.get("https://www.aviasales.by/");
        mainPageObject.fillOriginField()
                       .fillDestinationFiled()
                       .clickSearchButton()
                       .verifyNoWayText();

        mainPageObject.clickSearchButton();
    }

    @AfterTest
    public void afterTest() {


        webDriver.quit();
    }
}
