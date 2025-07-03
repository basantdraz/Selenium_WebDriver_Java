package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptTests extends BaseTests {
    @Test
    public void testScrolltoTable(){
        homePage.clickLargeAndDeepDOM().scrollToTable();
    }
    @Test
    public void testScrollInfinitePage(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
    @Test
    public void testAddMultipleAttributeToDropdown(){
        var dropdownPage = homePage.clickDropdown();
        dropdownPage.addMultipleAttribute();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropdownPage::selectFromDowndrop);

        var selectedOptions = dropdownPage.getSelectedOption();
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        assertEquals(selectedOptions.size(), optionsToSelect.size(), "Number of selected items");
    }
}
