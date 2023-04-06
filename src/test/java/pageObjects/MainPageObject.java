package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MainPageObject extends BasePage{
    static MainPageObject mainPageObject = null;


    By origin = By.xpath("//input[@id='origin']");
    By where = By.xpath("//input[@id='destination']");
    By noWay = By.xpath("//div[@data-test-id='card-text']/p");
    By button = By.xpath("//div[@class='avia-form__submit']//button[@type='submit']");

    private MainPageObject (WebDriver driver) {
        super(driver);
    }

    public static MainPageObject getIntance(WebDriver driver){
        if (mainPageObject == null) {
            mainPageObject = new MainPageObject(driver);
        }
        return mainPageObject;
    }


    public MainPageObject fillOriginField () {
        webDriver.findElement(origin).sendKeys("Минск");
        return this;
    }

    public MainPageObject fillDestinationFiled() {
        webDriver.findElement(where).sendKeys("Мальта");
        return this;
    }

    public MainPageObject clickSearchButton() {
        webDriver.findElement(button).click();
        return this;
    }

    public MainPageObject fillFormAndSend() {
        fillOriginField();
        fillDestinationFiled();
        clickSearchButton();
        return this;
    }

    public MainPageObject verifyNoWayText(){
        wait.until(ExpectedConditions.presenceOfElementLocated(noWay));
        Assert.assertEquals(webDriver.findElement(noWay).getText(), "Нет прямых рейсов");
        return this;
    }

}
