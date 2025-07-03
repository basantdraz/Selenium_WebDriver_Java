package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private By linkExample1 = By.xpath(".//a[contains(text(),'Example 1')]");
    private By linkExample2 = By.xpath(".//a[contains(text(),'Example 2')]");

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }
    public DynamicLoadingEx1Page clickExample1(){
        driver.findElement(linkExample1).click();
        return new DynamicLoadingEx1Page(driver);
    }
    public DynamicLoadingEx2Page clickExample2(){
        driver.findElement(linkExample2).click();
        return new DynamicLoadingEx2Page(driver);
    }
    public DynamicLoadingEx2Page rightClickonEx2Link(){
        driver.findElement(linkExample2).sendKeys(Keys.CONTROL,Keys.RETURN);
        return new DynamicLoadingEx2Page(driver);
    }

}
