package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

    public ContactsPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "//ul[@id='appmenu']//li[@data-id='contacts']")
    public WebElement contactsModule;



}
