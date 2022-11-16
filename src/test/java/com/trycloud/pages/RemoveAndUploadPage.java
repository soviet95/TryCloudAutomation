package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RemoveAndUploadPage {

    public RemoveAndUploadPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "user")
    public WebElement loginInput;

    @FindBy (id = "password")
    public WebElement passwordInput;

    @FindBy (id = "submit-form")
    public WebElement loginButton;

    @FindAll(@FindBy (xpath = "//ul[@id='appmenu']/li/a"))
    public List<WebElement> appMenu;


    @FindAll(@FindBy (xpath = "//span[@class='fileactions']/a[2]"))
    public List<WebElement> fileActions;

    @FindAll(@FindBy(xpath = "//div[@class='fileActionsMenu popovermenu bubble open menu']/ul/li/a/span[2]"))
    public List<WebElement> fileActionsOptions;

    @FindAll(@FindBy (xpath = "//div[@id='app-navigation']/ul/li"))
    public List<WebElement> appNav;

    @FindAll (@FindBy (xpath = "//div[@id='app-content-favorites']/table/tbody/tr/td/a/span/span[1]"))
    public List<WebElement> favorites;

    @FindBy (xpath = "//a[@class='button new']")
    public WebElement addIcon;

    @FindBy (xpath = "//input[@id='file_upload_start']")
    public WebElement fileUpload;

    @FindBy (css = "#uploadprogressbar")
    public WebElement progressBar;

    @FindAll( @FindBy (xpath = "//table[@id='filestable']/tbody/tr/td[2]/a/span/span[@class='innernametext']"))
    public List<WebElement> fileNames;

    public void addToFavorites() {
        for (WebElement each : fileActions){
            each.click();
            break;
        }
        for (WebElement each : fileActionsOptions){
            if (each.getText().equalsIgnoreCase("Add to favorites")){
                each.click();
                break;
            }
        }
    }
    
}
