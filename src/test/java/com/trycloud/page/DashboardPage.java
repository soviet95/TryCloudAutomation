package com.trycloud.page;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']/li")
    public List<WebElement> modules1;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@id='more-apps']/preceding-sibling::li")
    public List<WebElement> modules;


    public List<String> getModulesText() {

        List<String> modulesText = new ArrayList<>();
        for (int i = 0; i < modules1.size() - 1; i++) {

            BrowserUtils.hover(modules1.get(i));
            BrowserUtils.sleep(1);
            modulesText.add(modules1.get(i).getText());

        }
        return modulesText;

    }

    public void clickModulesWithText(String moduleName) {

        List<String> modulesText = new ArrayList<>();
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
