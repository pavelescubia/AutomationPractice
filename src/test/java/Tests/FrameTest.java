package Tests;

import HelpMethods.ElementMethods;
import HelpMethods.FrameMethods;
import HelpMethods.PageMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class FrameTest extends SharedData {
    @Test
    public void metodaTest() {

        ElementMethods elementHelper = new ElementMethods(driver);
        PageMethods pageHelper = new PageMethods(driver);
        FrameMethods frameHelper = new FrameMethods(driver);

        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        elementHelper.clickElement(skipSignIn);

        WebElement switchToElement = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        elementHelper.moveToElement(switchToElement);

        WebElement framesElement = driver.findElement(By.xpath("//a[text()='Frames']"));
        elementHelper.clickElement(framesElement);

        pageHelper.navigateUrl("https://demo.automationtesting.in/Frames.html");


        List<WebElement> buttonList = driver.findElements(By.cssSelector(".nav-tabs a"));
        buttonList.get(0).click();

        frameHelper.switchFrame("singleframe");

        WebElement inputEl = driver.findElement(By.cssSelector("input[type='text']"));
        inputEl.sendKeys("Ana are mere");

        frameHelper.switchToDefault();

        // driver.switchTo().defaultContent();  switch back to the entire page

        buttonList.get(1).click();
        frameHelper.switchFrame(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        frameHelper.switchFrame(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));

        WebElement inputEl2 = driver.findElement(By.cssSelector("input[type='text']"));
        inputEl2.sendKeys("Ana are mere");

        frameHelper.switchFrame(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));  //switch back to the first frame


    }
}
