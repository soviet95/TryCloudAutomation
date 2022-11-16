package com.trycloud.step_definitions;

import com.trycloud.page.DashboardPage;
import com.trycloud.page.LoginPage;
import com.trycloud.page.US_11_TalkModulePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_11_TalksModuleStepDef {
    US_11_TalkModulePage talkModulePage = new US_11_TalkModulePage();
    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        new LoginPage().login();


    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String talkModule) {
        new DashboardPage().clickModulesWithText(talkModule);


    }
    @Then("verify  the page title is {string}")
    public void verify_the_page_title_is(String expecterTalkTitle) {
        BrowserUtils.waitFor(2);
        Assert.assertEquals(expecterTalkTitle,Driver.getDriver().getTitle());

    }

    @When("user search user from the search box")
    public void user_search_user_from_the_search_box() {
        talkModulePage.searchBtn.sendKeys("User80");
        BrowserUtils.waitFor(2);
        talkModulePage.user80.click();
    }
    @When("user write a message")
    public void user_write_a_message() {

        talkModulePage.writeMessage.sendKeys(":)");


    }
    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {
        BrowserUtils.sleep(5);
        talkModulePage.submitMessage.click();




    }
    @Then("the user should be able to see the message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log() {
        Assert.assertTrue(talkModulePage.seeMessage.isDisplayed());



    }


}
