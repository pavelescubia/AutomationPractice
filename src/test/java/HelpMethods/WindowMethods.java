package HelpMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WindowMethods {
    public WebDriver driver;

    public WindowMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchSpecificWindow(Integer index){
        ArrayList<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window((tabList.get(index)));
        System.out.println("New Title: " + driver.getTitle());

    }

    public void closeWindow(){
        driver.close();
    }
}
