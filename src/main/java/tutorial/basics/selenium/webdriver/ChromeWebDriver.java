package tutorial.basics.selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver {
    private ChromeWebDriver(){
        /*Shouldn't be initialized*/
    }
    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\devtools\\chromedriver\\chromedriver.exe");
        return new ChromeDriver();
    }
}
