package tutorial.basics.selenium.webdriver.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {
    @Test
    public void startWebDriver(){
        WebDriver driver = null;
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\devtools\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");

        driver.navigate().to("https://plus.google.com/");
        Assert.assertTrue("Site title should start with Google+",driver.getTitle().startsWith("Google+"));
        driver.close();
        driver.quit();
    }
}
