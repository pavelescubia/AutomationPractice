package Tests;

import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import HelpMethods.WindowMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends SharedData {

    @Test
    public void metodaTest() {
        ElementMethods elementsHelper = new ElementMethods(driver);
        PageMethods pageHelper = new PageMethods(driver);
        WindowMethods windowHelper = new WindowMethods(driver);


        WebElement element = driver.findElement(By.id("btn2"));
        elementsHelper.clickElement(element);


        WebElement switchToElement = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        elementsHelper.moveToElement(switchToElement);

        WebElement windowsElement = driver.findElement(By.xpath("//a[text()='Windows']"));
        windowsElement.click();

        pageHelper.navigateUrl("https://demo.automationtesting.in/Windows.html");

        List<WebElement> windowOptions = driver.findElements(By.cssSelector(".nav-stacked>li>a"));
        windowOptions.get(0).click();

        WebElement clickSeleniumWeb = driver.findElement(By.cssSelector("#Tabbed button"));
        clickSeleniumWeb.click();

        // taburi diferite

        windowHelper.switchSpecificWindow(1);
        windowHelper.closeWindow();
        windowHelper.switchSpecificWindow(0);

        windowOptions.get(2).click();


        WebElement clickSeleniumTwoWindows = driver.findElement(By.cssSelector("#Multiple button"));
        clickSeleniumTwoWindows.click();

        windowHelper.switchSpecificWindow(2);
        windowHelper.closeWindow();
        windowHelper.switchSpecificWindow(1);
        windowHelper.closeWindow();
        windowHelper.switchSpecificWindow(0);

    }
}