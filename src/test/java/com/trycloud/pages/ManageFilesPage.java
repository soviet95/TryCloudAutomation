package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.joda.time.Seconds;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ManageFilesPage {
    public ManageFilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@id='user']")
    public WebElement usernameInput;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;
    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement invalidCredentialsMsg;

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement addIcon;
    @FindBy(xpath = "//span[normalize-space()='New folder']")
    public WebElement newFolderIcon;
    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement newFolderInput;
    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement submitBtn;
    @FindBy(xpath = "//td[@class='filename ui-draggable ui-draggable-handle']//span[@class='innernametext']")
    public List<WebElement> fileAndFoldersList;
    @FindBy(xpath = "//a[@class='menu-option option-delete']")
    public WebElement deleteFolderAction;
    //@FindBy(xpath = "//label[@for='file_upload_start']")
    @FindBy(xpath = "//label[@for='file_upload_start']")
    public WebElement uploadFileAction;
    @FindBy(xpath = "//div[@id='uploadprogressbar']")
    public WebElement uploadProgressBar;
    @FindBy(xpath = "//input[@type ='file']")
    public WebElement inputButton;
    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> fileName;
    @FindBy(xpath = "//tr[@data-type='dir']")
    public List<WebElement> folderOnlyList;
    @FindBy(xpath = "(//tr[@data-type='dir'])[1]")
    public WebElement firstFolder;

    public void addFolder(String folderName) {
        addIcon.click();
        newFolderIcon.click();
        newFolderInput.sendKeys(folderName);
        submitBtn.click();

    }

    public void deleteFolder(WebElement folder) {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(folder).perform();
        waitFor(1);
        deleteFolderAction.click();

    }

    public void verifyFileName(List<WebElement> listOfElements, String expected) {
        String actual = "";
        for (WebElement each : listOfElements) {
            if (each.getText().equalsIgnoreCase(expected)) {
                actual += "" + each.getText();
                break;
            }
        }
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    public  void verifyTitleContains(WebDriver driver, String expectedTitlePart) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitlePart));
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    /**
     * Extracts text from list of elements matching the provided locator into new List<String>
     *
     * @param locator
     * @return list of strings
     **/
    public static List<String> getElementsText(By locator) {

        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickElement(WebElement element) {
        waitForVisibility(element, 10);
        waitFor(1);
        element.click();
    }

    @FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Files']")
    public WebElement filesModule;


}
