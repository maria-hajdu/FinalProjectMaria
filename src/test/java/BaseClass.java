import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    WebDriver driver;
    private String petClinicURL = "http://bhdtest.endava.com/petclinic/";
    Header header;


    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/config/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(petClinicURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = new Header(driver);
        header.initElem();
    }
    @After
    public void afterTest(){
        driver.quit();
    }
}
