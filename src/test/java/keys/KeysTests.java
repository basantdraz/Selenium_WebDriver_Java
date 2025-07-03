package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class KeysTests extends BaseTests {
   @Test
   public void testBackSpace(){
       var keyPage = homePage.clickKeyPresses();
       keyPage.enterText("B" + Keys.BACK_SPACE);
       assertEquals(keyPage.getResult(), "You entered: BACK_SPACE", "Input result incorrect");
   }
    @Test
    public void testPi(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterPi();
        /*
            this test is not finished yet
         */
    }
}
