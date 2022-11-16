package com.trycloud.pages;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement userNameInput;


    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongPasswordMsg;

    public void login(String username, String password) {

        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }


    public void login(){
        login(ConfigurationReader.getProperty("userName"), ConfigurationReader.getProperty("password"));
        loginBtn.click();

    }
}
