package com.trycloud.step_definitions;

import com.cydeo.pages.FilesPage;
import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FileStepDefs {


    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env_try"));
        new LoginPage().login();
    }

    @When("user clicks {string} module")
    public void user_clicks_module(String moduleName) {
        new DashboardPage().clickModulesWithText(moduleName);
    }

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("user click the top left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        new FilesPage().checkAllFilesButton.click();
    }

    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        Assert.assertTrue(BrowserUtils.isAllSelected(new FilesPage().checkFileButtons));
    }

}
