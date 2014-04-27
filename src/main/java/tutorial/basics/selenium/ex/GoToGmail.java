package tutorial.basics.selenium.ex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tutorial.basics.selenium.webdriver.ChromeWebDriver;

/**
 * Log-in gmail and display inbox senders and message title Supports chrome
 */
public class GoToGmail
{
    public static final String EMAIL    = "your_mail@gmail.com"; // your_mail@gmail.com
    public static final String PASSWORD = "your_mail_id_pwd";   // your_mail_id_pwd

    public static void main(String[] args) throws Exception
    {
        /*The Chrome driver supports javascript*/
        WebDriver driver = ChromeWebDriver.getDriver();
        driver.manage().window().setPosition(new Point(900, 0));
        /*Go to the Google home page*/
        driver.get("https://www.google.co.in/?sesinv=1");
        String linkClassName = "gb_c";
        String linkText = "gmail";
        /*Open gmail*/
        openLink(driver, linkClassName, linkText);
        String formID = "gaia_loginform";
        Map<String, String> map = new HashMap<String, String>();
        map.put("Email", EMAIL);
        map.put("Passwd", PASSWORD);
        /*Submit form*/
        boolean isVisibleForm = isElementVisible(driver, "id", formID);
        if (isVisibleForm)
        {
            for (Map.Entry<String, String> id : map.entrySet())
            {
                driver.findElement(By.id(id.getKey())).sendKeys(id.getValue());
            }
            driver.findElement(By.id("signIn")).submit();
        }
        String mailDisplayAreaID = "gb";
        /*Display mailbox details*/
        boolean isVisibleMailBox = isElementVisible(driver, "id", mailDisplayAreaID, 50L);
        if (isVisibleMailBox)
        {
            String text = driver.findElement(By.id("gb")).findElement(By.cssSelector("a.gb_x.gb_2.gb_e")).getAttribute("title");
            if (text.contains(EMAIL))
            {
                System.out.println("Logged in as " + StringUtils.substringBeforeLast(text, "(").trim());
                WebElement messagesArea = driver.findElement(By.cssSelector("div.UI"));
                List<WebElement> trList = messagesArea.findElements(By.tagName("tr"));
                for (int i = 0; i < trList.size(); i++)
                {
                    WebElement senderSpan = trList.get(i).findElements(By.tagName("td")).get(4);
                    WebElement msgTitleSpan = trList.get(i).findElements(By.tagName("td")).get(5);
                    System.out.println("Mail-" + (i + 1) + " " + senderSpan.getText() + "(" + senderSpan.findElement(By.tagName("span")).getAttribute("email")
                            + ") - " + msgTitleSpan.findElements(By.tagName("span")).get(0).getText());
                }
                driver.manage().deleteAllCookies();
                System.out.println("All cookies cleared, don't worry about signing out ;)");
                closeBrowser(driver);
            }
        }
    }

    private static void closeBrowser(WebDriver driver)
    {
        /* Close and quit the driver*/
        driver.close();
        driver.quit();
    }

    /**
     * Opens link based on input link text
     * 
     * @param driver
     * @param linkClassName
     * @param linkText
     */
    private static void openLink(WebDriver driver, String linkClassName, String linkText)
    {
        boolean isVisible = isElementVisible(driver, "class", linkClassName);
        if (!isVisible)
        {
            System.out.println("Check the browser path");
            return;
        }
        List<WebElement> elementList = driver.findElements(By.className(linkClassName));
        for (WebElement element : elementList)
        {
            if (element.getText().equalsIgnoreCase(linkText))
            {
                element.click();
                System.out.println("In " + driver.getTitle().toUpperCase() + " page...!");
                break;
            }
            else
            {
                System.out.println("Link " + element.getText() + " is not desired");
            }
        }
    }

    private static boolean isElementVisible(WebDriver driver, String classOrID, String linkClassName)
    {
        return isElementVisible(driver, classOrID, linkClassName, 5L);
    }

    private static boolean isElementVisible(WebDriver driver, String classOrID, String linkClassName, Long timeInMS)
    {
        boolean isVisible = false;
        WebElement element = null;
        /*verify and get the element based on class or id*/
        if (classOrID.equalsIgnoreCase("class"))
        {
            WebDriverWait wait = new WebDriverWait(driver, timeInMS);
            element = wait.until(ExpectedConditions.elementToBeClickable(By.className(linkClassName)));
        }
        else if (classOrID.equalsIgnoreCase("id"))
        {
            WebDriverWait wait = new WebDriverWait(driver, timeInMS);
            element = wait.until(ExpectedConditions.elementToBeClickable(By.id(linkClassName)));
        }
        if (element != null && element.isDisplayed())
        {
            System.out.println("Tag " + element.getTagName().toUpperCase() + " is visible");
            isVisible = true;
        }
        return isVisible;
    }

}
