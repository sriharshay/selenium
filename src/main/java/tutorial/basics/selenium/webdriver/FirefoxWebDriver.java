package tutorial.basics.selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxWebDriver {
        private FirefoxWebDriver(){
        /*Shouldn't be initialized*/
        }
        public static WebDriver getDriver(){
            return new FirefoxDriver();
        }
}
