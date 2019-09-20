import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;

import java.util.concurrent.TimeUnit;

public class HomepageTests extends BaseClass{
    private WebElement welcomeText;
    private WebElement welcomeImage;


    @Test
    public void welcomeText(){
        header.getHomeButton().click();
        welcomeText=driver.findElement(By.xpath("//app-welcome//h1"));
        Assert.assertEquals("Welcome to Petclinic",welcomeText.getText());
    }

    @Test
    public void welcomeImage(){
        header.getHomeButton().click();
        welcomeImage=driver.findElement(By.xpath("//app-welcome//img"));
        Assert.assertTrue("true",welcomeImage.isDisplayed());
    }
}
