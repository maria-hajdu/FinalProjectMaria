package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Pets {
    WebDriver driver;
    private WebElement addPetButton;
    private WebElement petInputName;
    private WebElement savePetButton;
    private List<WebElement> petsList;
    private List<WebElement> deleteButtons;
    private WebElement editButton;

    public Pets(WebDriver driver)  {
        this.driver = driver;
    }
    public void addPet(String name) throws InterruptedException {
        addPetButton = driver.findElement(By.xpath("//div//button[contains(.,\"Add\")]"));
        addPetButton.click();
        Thread.sleep(2000);
        petInputName = driver.findElement(By.xpath("//input[@id=\"name\"]"));
        petInputName.sendKeys(name);
        savePetButton = driver.findElement(By.xpath("//div//button[contains(.,\"Save\")]"));
        savePetButton.click();
    }

    public boolean checkPet(String name) {
        petsList = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//input"));
        for (WebElement e : petsList) {
            if (e.getAttribute("value").contains(name)) {
                break;
            }
        }
        return true;
    }

    public void deletePet(String name) {
        int index = 0;
        petsList = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//input"));
        deleteButtons = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//tr//td[2]//button[2]"));
        for (int i = 0; i < petsList.size(); i++) {
            if (petsList.get(i).getAttribute("value").contains(name)) {
                index = i;
            }
        }
        for (int j = 0; j < deleteButtons.size(); j++) {
            if (j == index) {
                deleteButtons.get(j).click();
                break;
            }
        }
    }

    public boolean checkPetDeleted(String name) {
        petsList = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//input"));
        boolean check = false;
        for (WebElement e : petsList) {
            if (!e.getAttribute("value").contains(name)) {
                check = true;
            }
        }
        return check;

    }

    public void editPet(String name, String newName) throws InterruptedException {
        petsList = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//input"));
        for (int i = 0; i < petsList.size(); i++) {
            if (petsList.get(i).getAttribute("value").contains(name)) {
                editButton = driver.findElement(By.xpath("//table[@class=\"table table-striped\"]//tr[" + (i + 1) + "]//td[2]//button[1]"));
                editButton.click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//input[@id=\"name\"]")).clear();
                driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys(newName, Keys.ENTER);
                break;
            }
        }
    }

    public boolean checkPetEdited(String name) {
        petsList = driver.findElements(By.xpath("//table[@class=\"table table-striped\"]//input"));
        for (int i = 0; i < petsList.size(); i++) {
            if (petsList.get(i).getAttribute("value").contains(name)) {
                break;
            }
        }
        return true;
    }
}

