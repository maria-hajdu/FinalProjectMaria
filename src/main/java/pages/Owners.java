package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Owners {
    WebDriver driver;
    Header header;

//    public Owners(WebDriver driver, WebDriver driver1) {
//        super(driver);
//        this.driver = driver1;
//    }
        public Owners(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement ownersAddOwnerButton;
    private WebElement ownersAllButton;
    private WebElement firstNameInput;
    private WebElement lastNameInput;
    private WebElement addressInput;
    private WebElement cityInput;
    private WebElement telephoneInput;
    private WebElement addOwnerButton;
    private List<WebElement> ownersList;

    Faker faker=new Faker();

    private String firstName=faker.name().firstName();
    private String lastname=faker.name().lastName();
    private String address=faker.address().streetAddress();
    private String city=faker.address().city();

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    private Random rand=new Random();
    private int telephone=rand.nextInt(200);

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public void addOwner(String firstName, String lastName, String address, String city, int telephone) throws InterruptedException {
        header = new Header(driver);
        header.initElem();
        header.getOwnersButton().click();
        ownersAddOwnerButton = driver.findElement(By.xpath("(//li[@class=\"dropdown open\"]//a[contains(@href,\"/owners\")])[2]"));
        ownersAddOwnerButton.click();
        firstNameInput = driver.findElement(By.xpath("//input[@id=\"firstName\"]"));
        firstNameInput.sendKeys(firstName);
        lastNameInput = driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
        lastNameInput.sendKeys(lastName);
        addressInput = driver.findElement(By.xpath("//input[@id=\"address\"]"));
        addressInput.sendKeys(address);
        cityInput = driver.findElement(By.xpath("//input[@id=\"city\"]"));
        cityInput.sendKeys(city);
        telephoneInput = driver.findElement(By.xpath("//input[@id=\"telephone\"]"));
        telephoneInput.sendKeys(Integer.toString(telephone));
        addOwnerButton = driver.findElement(By.xpath("//div[@class=\"col-sm-offset-2 col-sm-10\"]//button[2]"));
        addOwnerButton.click();
    }

    public boolean checkOwner(String firstName, String lastName) {
        ownersList = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//tr//td"));
        for (WebElement e : ownersList) {
            if (e.getText().contains(firstName + " " + lastName)) {
                break;
            }
        }
        return true;
    }

}
