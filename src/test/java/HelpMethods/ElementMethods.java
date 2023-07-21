package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementMethods {

    public WebDriver driver;

    public ElementMethods(WebDriver driver){
        this.driver = driver;
    }
    // WAIT
    // 2 feluri: implicit si explicit

    public void clickElement (WebElement element){
        WaitVisibleElement(element);
        element.click();
    }

    public void WaitVisibleElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }

    public void FillElement(WebElement element, String value){
        WaitVisibleElement(element);
        element.sendKeys(value);
    }

    public void SelectDropDownText(WebElement element, String value){
        WaitVisibleElement(element);
        Select elementSelect = new Select(element);
        elementSelect.selectByVisibleText(value);
    }

    public void SelectDropDownValue(WebElement element, String value){
        WaitVisibleElement(element);
        Select elementSelect = new Select(element);
        elementSelect.selectByValue(value);
    }

    public void ValidateElementMessage(WebElement element, String value){
        WaitVisibleElement(element);
        String actualMessage = element.getText();
        // testam daca exista un mesaj in pagina
        Assert.assertEquals(actualMessage, value, "Textul de pe element nu este corect");

    }

    public void moveToElement(WebElement element){
        WaitVisibleElement(element);
        Actions actiuni = new Actions(driver);
        actiuni.moveToElement(element).perform();

    }
}
