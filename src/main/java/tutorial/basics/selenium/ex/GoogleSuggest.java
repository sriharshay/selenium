package tutorial.basics.selenium.ex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tutorial.basics.selenium.webdriver.ChromeWebDriver;

/**
 * Created by Sriharsha on 26-04-2014.
 */
public class GoogleSuggest
{
    public static void main(String[] args) throws Exception
    {
        // The Firefox driver supports javascript
        WebDriver driver = ChromeWebDriver.getDriver();

        // Go to the Google Suggest home page
        driver.get("https://www.google.co.in/?sesinv=1");

        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("planet");

        // Sleep until the div we want is visible or 5 seconds is over
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end)
        {
            WebElement resultsDiv = driver.findElement(By.className("gssb_e"));

            // If results have been returned, the results are displayed in a drop down.
            if (resultsDiv.isDisplayed())
            {
                break;
            }
        }

        // And now list the suggestions
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));

        for (WebElement suggestion : allSuggestions)
        {
            System.out.println(suggestion.getText());
        }
        driver.close();
        driver.quit();
    }
}
