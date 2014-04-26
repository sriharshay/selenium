package tutorial.basics.selenium.webdriver.tutorial.basics.selenium.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sriharsha on 26-04-2014.
 */
public class FirefoxWebDriver {
        private FirefoxWebDriver(){
        /*Shouldn't be initialized*/
        }
        public static WebDriver getDriver(){
            return new FirefoxDriver();
        }
}
