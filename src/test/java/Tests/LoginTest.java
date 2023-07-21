package Tests;

import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementMethods elementMethods = new ElementMethods(driver);
        PageMethods pageMethod = new PageMethods(driver);


        // Identificam un element
        WebElement signInElement = driver.findElement(By.id("btn1"));
        // signInElement.click();
        elementMethods.clickElement(signInElement);

        // Validam o anumita pagina
        String signInTitlu = "SignIn";
        pageMethod.ValidatePageTitle(signInTitlu);
        // Assert.assertTrue(driver.getTitle(), signInTitlu);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "email@email.com";
        //emailElement.sendKeys(emailValue);
        elementMethods.FillElement(emailElement, emailValue);

        WebElement passwordElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passwordValue = "password";
        // passwordElement.sendKeys(passwordValue);
        elementMethods.FillElement(passwordElement, passwordValue);

        WebElement enterElement = driver.findElement(By.id("enterbtn"));
        enterElement.click();
        WebElement errorElement = driver.findElement(By.id("errormsg"));
        String expectedMessage = "Invalid User Name or PassWord";
        elementMethods.ValidateElementMessage(errorElement, expectedMessage);
        // String actualMessage = errorElement.getText();
        // testam daca exista un mesaj in pagina
        // Assert.assertEquals(actualMessage, expectedMessage, "Textul de pe element nu este corect");


        driver.quit();
       // driver.close();

        // quit inchide browserul cu toate taburile.
        // close inchide tabul curent.
    }
}
