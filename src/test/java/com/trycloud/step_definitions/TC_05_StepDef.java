package com.trycloud.step_definitions;

import com.trycloud.page.HomePage;
import com.trycloud.page.TC_05Page;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class TC_05_StepDef {

HomePage homePage;
    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() throws InterruptedException {
      Driver.getDriver().get(ConfigurationReader.getProperty("url"));

      homePage =new HomePage();

        homePage.username.sendKeys(ConfigurationReader.getProperty("username"));
        homePage.password.sendKeys(ConfigurationReader.getProperty("password"));
        homePage.loginButton.click();

        Thread.sleep(3000);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));



    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String fileModule) {
        TC_05Page tc_05Page =new TC_05Page();
        tc_05Page.fileModuleButton.click();


    }


    @When("the user clicks action-icon  from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() throws InterruptedException {
TC_05Page tc_05Page = new TC_05Page();
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(3000);
        actions.contextClick(tc_05Page.checkBox).perform();


    }
    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {



    }
    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {

    }
    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {

    }

}
