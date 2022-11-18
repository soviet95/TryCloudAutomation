package com.trycloud.pages;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Modules_Page {

    public Modules_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@tabindex='-1']")
    public List<WebElement> modules;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id='dashboard']")
    public WebElement dashboardModule;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id='files']")
    public WebElement filesModule;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id='photos']")
    public WebElement photosModule;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id='activity']")
    public WebElement activityModule;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id='spreed']")
    public WebElement talkModule;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id='mail']")
    public WebElement mailModule;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id='contacts']")
    public WebElement contactsModule;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id='circles']")
    public WebElement circlesModule;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id='calendar']")
    public WebElement calendarModule;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id='deck']")
    public WebElement deckModule;

    //----------LOG IN-----

    @FindBy(xpath = "//input[@id='user']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;




    public  void logIn(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginBtn.click();
    }

}
