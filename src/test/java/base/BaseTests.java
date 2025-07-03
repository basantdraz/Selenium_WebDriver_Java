package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;
import java.io.File;
import java.io.IOException;
import utils.CookieManager;


public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;
@BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        goHome();
        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    public WindowManager getWindowManager(){
    return new WindowManager(driver);
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }

    public CookieManager getCookieManager(){
        return new CookieManager(driver);
    }
/*
  * @Test
  *  public void shiftingContent() {
  *     //An Example to find elments and take actions without framework
  *     WebElement shiftingLink = driver.findElement(By.linkText("Shifting Content"));
  *     shiftingLink.click();
  *     WebElement menuLink = driver.findElement(By.linkText("Example 1: Menu Element"));
  *     menuLink.click();
  *     List<WebElement> menuElements = driver.findElements(By.tagName("li"));
  *     System.out.println(menuElements.size());
  *     System.out.println(driver.getTitle());
  *  }
*/
    public static void main(String args[]){
        BaseTests test = new BaseTests();
        test.setUp();
    }

}
