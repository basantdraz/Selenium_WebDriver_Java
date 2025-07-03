package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        var uploadPage=homePage.clickFileUpload();
        uploadPage.uploadFile("D:\\Testing\\Java web UI path Course\\6-Selenium WebDriver with Java\\webdriver_java\\resources\\chromedriver.exe");
        assertEquals(uploadPage.getUploadedFile(), "chromedriver.exe", "Upload Failed");
    }
}
