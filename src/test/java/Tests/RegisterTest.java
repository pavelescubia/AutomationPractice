package Tests;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementMethods elementMethod = new ElementMethods(driver);

        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        // skipSignIn.click();
        elementMethod.clickElement(skipSignIn);

        WebElement firstName = driver.findElement(By.cssSelector("input[ng-model='FirstName'])"));
        String firstNameValue = "Bianca";
        // firstName.sendKeys(firstNameValue);
        elementMethod.FillElement(firstName, firstNameValue);

        WebElement lastName = driver.findElement(By.xpath("//input[@ng-model='LastName']"));
        String lastNameValue = "Pavelescu";
        // lastName.sendKeys(lastNameValue);
        elementMethod.FillElement(lastName,lastNameValue);

        WebElement skillsSelector = driver.findElement(By.id("Skills"));
        String skillsValue = "Java";
        // Select skillsSelect = new Select(skillsSelector);
        // skillsSelect.selectByVisibleText(skillsValue);
        elementMethod.SelectDropDownText(skillsSelector, skillsValue);

        WebElement yearSelector = driver.findElement(By.id("yearbox"));
        String yearValue = "1998";
        // Select yearSelect = new Select(yearSelector);
        // yearSelect.selectByValue(yearValue);
        elementMethod.SelectDropDownValue(yearSelector, yearValue);

        WebElement languageElement =driver.findElement(By.id("msdd"));
        languageElement.click();

        List<WebElement> languageList = driver.findElements(By.cssSelector(".ui-autocomplete>li>a"));
        for (Integer index =0; index<languageList.size(); index++){
            if (languageList.get(index).getText().equals("English")){
                languageList.get(index).click();
                break;
            }
        }

        WebElement genderElement = driver.findElement(By.cssSelector("input[value='FeMale']"));
        genderElement.click();

        WebElement selectCountryElement = driver.findElement(By.cssSelector(".select2-selection--single"));
        selectCountryElement.click();

        WebElement selectCountryInput = driver.findElement(By.cssSelector(".select2-search__field"));
        selectCountryInput.sendKeys("Denmark");
        selectCountryInput.sendKeys(Keys.ENTER);

        WebElement fileElement = driver.findElement(By.id("imagesrc"));
        fileElement.sendKeys("image.jpg");



    }
}