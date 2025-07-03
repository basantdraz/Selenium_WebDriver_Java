package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alertClickToAccept();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Result message is incorrect");
    }
    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
       String text = alertsPage.alertGetText();
       alertsPage.alertClickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert Text incorrect");
    }
    @Test
    public void testSetInputInAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        alertsPage.alertSetInput("Web Testing");
        alertsPage.alertClickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: "+"Web Testing", "Result is incorrect");
    }

}
