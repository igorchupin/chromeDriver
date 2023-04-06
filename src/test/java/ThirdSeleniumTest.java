import org.testng.annotations.Test;

public class ThirdSeleniumTest extends BaseTest{
    @Test
    public void firstTest(){
        webDriver.get("https://www.aviasales.by/");
        mainPageObject.fillOriginField()
                .fillDestinationFiled()
                .clickSearchButton()
                .verifyNoWayText();

        mainPageObject.clickSearchButton();
    }
}
