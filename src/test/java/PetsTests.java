
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;
import pages.Owners;
import pages.Pets;

import java.util.concurrent.TimeUnit;

public class PetsTests extends BaseClass {

    Pets pets;


  Faker faker;

    @Test
    public void addPet() throws InterruptedException {
        faker=new Faker();
        String animal=faker.name().fullName();
        pets=new Pets(driver);
        header.initElem();
        header.getPetTypes().click();
        Thread.sleep(2000);
        pets.addPet(animal);
        pets.checkPet(animal);
        Assert.assertTrue(pets.checkPet(animal));
    }

    @Test
    public void deletePet() throws InterruptedException {
        faker=new Faker();
        String animal=faker.name().fullName();
        header.initElem();
        header.getPetTypes().click();
        pets.addPet(animal);
        header.initElem();
        header.getPetTypes().click();
        pets.deletePet(animal);
        pets.checkPetDeleted(animal);
        Assert.assertTrue(pets.checkPetDeleted(animal));
    }
    @Test
    public void editPet() throws InterruptedException {
        faker=new Faker();
        String animal=faker.name().fullName();
        String newAnimal=faker.name().fullName();
        header.initElem();
        header.getPetTypes().click();
        pets.addPet(animal);
        Thread.sleep(3000);
        header.initElem();
        header.getPetTypes().click();
        pets.editPet(animal,newAnimal);
        Assert.assertTrue(pets.checkPetEdited(newAnimal));
    }
}