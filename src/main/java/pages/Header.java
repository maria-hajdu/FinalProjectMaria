package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Header {
    public WebDriver driver;
    private WebElement homeButton;
    private WebElement ownersButton;
    private WebElement ownersAllButton;
    private WebElement ownersAddOwnerButton;
    private WebElement vetsButton;
    private WebElement vetsAllButton;
    private WebElement vetsAddVetButton;
    private WebElement petTypes;
    private WebElement specialties;

    public WebElement getHomeButton() {
        return homeButton;
    }

    public void setHomeButton(WebElement homeButton) {
        this.homeButton = homeButton;
    }

    public WebElement getPetTypes() {
        return petTypes;
    }

    public void setPetTypes(WebElement petTypes) {
        this.petTypes = petTypes;
    }

    public WebElement getOwnersButton() {
        return ownersButton;
    }

    public void setOwnersButton(WebElement ownersButton) {
        this.ownersButton = ownersButton;
    }

    public WebElement getVetsButton() {
        return vetsButton;
    }

    public void setVetsButton(WebElement vetsButton) {
        this.vetsButton = vetsButton;
    }

    public void initElem() {
        homeButton = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]//a[contains(@href,\"/welcome\")]"));
        ownersButton=driver.findElement(By.xpath("//li[@class=\"dropdown\"][1]"));
        vetsButton=driver.findElement(By.xpath("//li[@class=\"dropdown\"][2]"));
//        ownersAllButton = driver.findElement(By.xpath("(//li[@class=\"dropdown open\"]//a[contains(@href,\"/owners\")])[1]"));
//
//        vetsAllButton = driver.findElement(By.xpath("(//li[@class=\"dropdown open\"]//a[contains(@href,\"/vets\")])[1]"));
//        vetsAddVetButton = driver.findElement(By.xpath("(//li[@class=\"dropdown open\"]//a[contains(@href,\"/vets\")])[2]"));
        petTypes = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]//a[contains(@href,\"/pettypes\")]"));
        specialties = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]//a[contains(@href,\"/specialties\")]"));

    }

    public Header(WebDriver driver) {

        this.driver = driver;
    }


}
