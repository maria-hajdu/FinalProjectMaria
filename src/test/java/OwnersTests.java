import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;
import pages.Owners;

import java.util.concurrent.TimeUnit;

public class OwnersTests extends BaseClass{

    Owners owners;

    @Test
    public void addOwners() throws InterruptedException {
        owners=new Owners(driver);
        owners.addOwner(owners.getFirstName(),owners.getLastname(),owners.getAddress(),owners.getCity(),owners.getTelephone());
        owners.checkOwner(owners.getFirstName(),owners.getLastname());
        Assert.assertTrue(owners.checkOwner(owners.getFirstName(),owners.getLastname()));

    }
}
