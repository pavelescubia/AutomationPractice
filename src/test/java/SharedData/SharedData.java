package SharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SharedData {
    public WebDriver driver;

    @BeforeMethod

    public void prepaireDriver() {

        // Trebuie sa setam driverul de chrome.
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        // Accesam un anumit url: https://demo.automationtesting.in/Index.html
        driver.get("https://demo.automationtesting.in/Index.html");
        // facem browserul in mod maximised.
        driver.manage().window().maximize();
        // Wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

}

