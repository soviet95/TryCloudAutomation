package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UpdateSettingsPage {
    public UpdateSettingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//button[normalize-space()='Settings']")
    public WebElement settingsBtn;


    @FindBy(xpath = "//div[contains(@id,'settings')]//input[@class='checkbox'] ")
    public List<WebElement> settingsOptions;


    @FindBy(xpath = "//a[@class='icon-quota svg']")
    public WebElement storageUsage;

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement addIcon;


    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement uploadFileInput;
    //input[@type='file']


    @FindBy(xpath = "//div[@id='uploadprogressbar']")
    public WebElement uploadBar;


    public boolean isAllSelected(List<WebElement> allFiles){

        for (WebElement file : allFiles) {

            if(!file.isSelected()){
                return false;
            }
        }
        return true;
    }



}
