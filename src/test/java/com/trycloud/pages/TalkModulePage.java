package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalkModulePage {
    public TalkModulePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@class='app-navigation-search__input']")
    public WebElement searchBtn;


    @FindBy(xpath = "//ul[@class='conversations']")
    public WebElement user80;


    @FindBy(xpath = "//div[@placeholder='Write message, @ to mention someone …']")
    public WebElement writeMessage;


    @FindBy(xpath = "//button[@aria-label='Send message']")
    public WebElement submitMessage;

    @FindBy(xpath = "//div[@class='scroller']")
    public WebElement seeMessage;

}
