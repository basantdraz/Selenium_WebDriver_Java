package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import static org.testng.Assert.*;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption() {
       var dropDwonPage = homePage.clickDropdown();
       String option = "Option 1";
       dropDwonPage.selectFromDowndrop(option);
       var selectedOptions = dropDwonPage.getSelectedOption();
        assertEquals(selectedOptions.size(), 1, "Incorrect Number of selections");
        assertTrue(selectedOptions.contains(option), "Option not Selected");
    }
}
