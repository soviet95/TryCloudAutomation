package com.trycloud.page;

import com.trycloud.utilities.BrowserUtils;
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
    public WebElement txt_username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement txt_password;


    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement btn_login;
    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongPasswordMsg;




    public void login(String username, String password) {
        txt_username.sendKeys(username);
        txt_password.sendKeys(password);
    }


    public void login(){
        login(ConfigurationReader.getProperty("userName"), ConfigurationReader.getProperty("password"));
        BrowserUtils.clickElement(btn_login);

    }
}
