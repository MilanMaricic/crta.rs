import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class checkPageTitleTest {
    AppTest app = new AppTest();
    private String siteURL = "https://crta.rs";
    private WebDriver driver;
    private String expectedTitle[] = {
            "CRTA :Home - CRTA",
            "CRTA :O nama - CRTA",
            "CRTA :Istraživanja - CRTA",
            "CRTA :Blog Archives - CRTA",
            "CRTA :Jedno veliko i milijun malih srca - CRTA"
    };


    @Test
    public void checkRandomlyFiveTitlePages() throws InterruptedException {
        String projectLocation = System.getProperty("user.dir");

        //configure WebDriver which will be used for test execution
        System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\geckodriver\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();

        //System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\chromedriver\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        //driver = new ChromeDriver();

        //initial setup
         driver.manage().window().maximize();

        //navigate to crta.rs home page
        driver.get(siteURL);
        Assert.assertEquals(driver.getTitle(), expectedTitle[0]);

        driver.findElement(By.id("menu-item-7977")).click();
        Assert.assertEquals(driver.getTitle(),expectedTitle[1]);


        driver.findElement(By.xpath("//*[@id=\"services\"]/div/div/div[2]/div/div/div/div/div[1]/div[3]/div/div[6]/div[2]/div[2]/div/a")).click();
        Assert.assertEquals(driver.getTitle(),expectedTitle[2]);

        driver.findElement(By.id("menu-item-7957")).click();
        Assert.assertEquals(driver.getTitle(),expectedTitle[3]);

        driver.findElement(By.xpath("//*[@id=\"post-22405\"]/div/div/div[1]/a")).click();
        Assert.assertEquals(driver.getTitle(),expectedTitle[4]);




        /*
        //WebElement randomPage[] = new WebElement[5];
        WebElement menuArea = driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div/div/div/div/div/div[1]"));
        ArrayList<String> titleArray = new ArrayList();
        List<WebElement> l1 = menuArea.findElements(By.tagName("a"));
        System.out.println("L1 size is:" + l1.size());

        // go true all
        for (int i = 0; i < l1.size()-48; i++) {
            Random r = new Random();
            l1.get(r.nextInt(6)).click();
            String pageTitle = driver.getTitle();
            System.out.println("Page title is: " + pageTitle);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            //Assert need to be implemented

            //navigate again on home page
            driver.get(siteURL);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            menuArea = driver.findElement(By.xpath("/html/body/main/div/div[2]/div/div/div/div/div/div/div/div[1]"));
            l1 = menuArea.findElements(By.tagName("a"));
            }
         */

        driver.quit();
        }
}




