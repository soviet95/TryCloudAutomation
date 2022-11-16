package com.trycloud.step_definitions;

import com.trycloud.pages.BasePage;
import com.trycloud.pages.LoginPage;
import com.trycloud.pages.US_10_UpdateSettingsPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US_10_UpdateSettingsStepDef {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    US_10_UpdateSettingsPage updateSettingsPage = new US_10_UpdateSettingsPage();

    String beforeStorageUsage;
    String afterStorageUsage;

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        loginPage.userNameInput.sendKeys(ConfigurationReader.getProperty("userName"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();

    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        basePage.clickModulesWithText(string);

    }
    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        updateSettingsPage.settingsBtn.click();
    }

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {

        for(WebElement each: updateSettingsPage.settingsOptions){
            each.isSelected();
        }
        updateSettingsPage.isAllSelected(updateSettingsPage.settingsOptions);


    }

    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        beforeStorageUsage = updateSettingsPage.storageUsage.getText();
        System.out.println("Storage before: " + beforeStorageUsage);
    }

    @When("user  uploads file with the upload file option")
    public void user_uploads_file_with_the_upload_file_option() throws InterruptedException {
        updateSettingsPage.addIcon.click();
        Thread.sleep(3000);

        updateSettingsPage.uploadFileInput.sendKeys("C:\\Users\\tatia\\Downloads\\ReadMe.pdf");
        Thread.sleep(3000);

        BrowserUtils.waitForInvisibilityOf(updateSettingsPage.uploadBar);
    }

    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
    }

    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
        afterStorageUsage =updateSettingsPage.storageUsage.getText();
        System.out.println("Storage after: " + afterStorageUsage);

        Assert.assertTrue(afterStorageUsage.length()>beforeStorageUsage.length());

    }
    }





