package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver webDriver;
    WebDriverWait wait;


    public BasePage (WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 10);
    }
}
