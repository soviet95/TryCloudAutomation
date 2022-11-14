package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public static  void waitForInvisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static List<String> dropdownOptionsAsString(WebElement dropdown){
        Select select = new Select(dropdown);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        List<String> actualOptionsAsString = new ArrayList<>();
        for (WebElement each : actualOptionsAsWebElement){
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){
        for (WebElement each : radioButtons){
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }

    public static void sleep(int seconds){
        // 1 second = 1000 millis
        // millis = seconds*1000
        try {
            Thread.sleep(seconds*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method!");
        }
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }


    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void clickElement(WebElement element){
        waitForVisibility(element,10);
        waitFor(1);
        element.click();
    }




}
