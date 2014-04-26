package tutorial.basics.selenium.webdriver.tutorial.basics.selenium.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Sriharsha on 26-04-2014.
 */
public class ChromeWebDriver {
    private ChromeWebDriver(){
        /*Shouldn't be initialized*/
    }
    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\gs\\codebase\\SeleniumBasics\\chromedriver\\chromedriver.exe");
        return new ChromeDriver();
    }
}
