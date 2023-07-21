package Tests;

import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertTest extends SharedData {

    private static WebDriver webDriver = null;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bpavelescu\\Downloads\\chromedriver-exe/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void metodaTest(){
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        skipSignIn.click();

        WebElement switchToElement = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions actiuni = new Actions(driver);
        actiuni.moveToElement(switchToElement).perform();

        WebElement alertsElement = driver.findElement(By.xpath("//a[text()='Alerts']"));
        alertsElement.click();


        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
    }

}
