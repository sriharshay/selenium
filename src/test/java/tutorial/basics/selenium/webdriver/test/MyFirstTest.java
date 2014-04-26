package tutorial.basics.selenium.webdriver.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sriharsha on 26-04-2014.
 */
public class MyFirstTest {
    @Test
    public void startWebDriver(){
        WebDriver driver = null;
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\gs\\codebase\\SeleniumBasics\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");

        driver.navigate().to("https://plus.google.com/");
        Assert.assertTrue("Site title should start with Google+",driver.getTitle().startsWith("Google+"));
        driver.close();
        driver.quit();
    }
}
