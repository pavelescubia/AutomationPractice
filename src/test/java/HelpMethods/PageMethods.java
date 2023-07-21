package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageMethods {
    public WebDriver driver;

    public PageMethods(WebDriver driver){
        this.driver = driver;
    }

    public void WaitPageTitle(String value){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.titleIs(value));
    }

    public void ValidatePageTitle(String value){
        WaitPageTitle(value);
        Assert.assertTrue(driver.getTitle().equals(value));
    }

    public void navigateUrl(String url){
        driver.navigate().to(url);
    }
}
