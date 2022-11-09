package com.trycloud.page;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_05Page {

    public TC_05Page(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "(//*[@data-id='files'])[1]")
    public WebElement fileModuleButton;

    @FindBy (xpath = "(//tbody[@id='fileList']//td/label)[1]")
    public WebElement checkBox;

}
