import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppTest {

    public String siteURL = "https://crta.rs";


    @Test
    public void loadPageTest() {
        //Location/path of our project
        String projectLocation = System.getProperty("user.dir");

        //configure WebDriver which will be used for test execution
        System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        WebDriver driver = new FirefoxDriver();

        //commands for executing what test will do
        driver.get(siteURL);
        Assert.assertEquals(driver.getTitle(), "CRTA :Home - CRTA" );
        driver.quit();


    }

}


