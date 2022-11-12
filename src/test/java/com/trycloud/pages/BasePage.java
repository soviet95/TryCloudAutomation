package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//li[@tabindex='-1']")
    public List<WebElement> allModules;

    @FindBy(xpath = "//ul[@id='appmenu']/li")
    public List<WebElement> modules1;


    @FindBy(xpath = "//ul[@id='appmenu']/li[@id='more-apps']/preceding-sibling::li")
    public List<WebElement> modules;

    public void clickModulesWithText(String moduleName) {

        for (int i = 0; i < modules1.size() - 1; i++) {

            BrowserUtils.hover(modules1.get(i));
            BrowserUtils.sleep(1);
            if (modules1.get(i).getText().equals(moduleName)) {
                BrowserUtils.clickElement(modules1.get(i));
                break;
            }

        }

    }

}
