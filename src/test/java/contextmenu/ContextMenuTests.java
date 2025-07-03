package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {
    @Test
    public void testRightClick(){
        var menuPage = homePage.clickContextMenu();
        menuPage.rightClickBox();
        String message = menuPage.getPopupText();
        menuPage.acceptPopup();
        assertEquals(message, "You selected a context menu", "Popup message incorrect");
    }
}
