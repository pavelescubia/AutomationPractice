package Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class name {
    WebDriver driver = new ChromeDriver();

    @Test
    public void test() {
        driver.get("https://chirath02.github.io/");
        Assert.assertEquals(driver.getTitle(), "Chirath R");
        driver.quit();
    }
}

