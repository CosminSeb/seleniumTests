package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class CommonTask {

    public WebDriver driver;


    public static void clearElement(WebElement element, String elementName) {
        try {
            System.out.println("- clearing field : " + elementName);
            element.clear();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found : " + elementName);
        }
    }


    public static void moveToElement(WebDriver driver, WebElement element, String elementName) {
        System.out.println("- moving to element : " + elementName);
        try {
            Actions action = new Actions(driver);
            action.moveToElement(element).build().perform();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found : " + elementName);
        }
    }


    public static void sendKeys(WebElement element, String text, String elementName) {
        System.out.println("- sending keys : '" + text + "' : to " + elementName);
        try {
            System.out.println("- sending keys : '" + text + "' : to " + elementName);
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found : " + elementName);
        }

    }

    public static void clickElement(WebDriver driver, WebElement element, String elementName) {
        try {
            System.out.println("- waiting for element : " + elementName);
            Waiting.elementToBeClickable(driver, element, elementName);

            moveToElement(driver, element, elementName);

            System.out.println("- clicking element : " + elementName);

            element.click();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found : " + elementName);
        }
    }


    public static void scrollIntoView(WebDriver driver, WebElement element) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            System.out.println("Move the view to the following element : " + element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (java.util.NoSuchElementException e) {
            System.out.println("The element:  " + element + "is not present");
        }
    }
}
