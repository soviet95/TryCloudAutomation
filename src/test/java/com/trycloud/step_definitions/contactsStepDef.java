package com.trycloud.step_definitions;

import com.trycloud.pages.ContactsPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class contactsStepDef {
    LoginPage loginPage = new LoginPage();
    ContactsPage contactsPage = new ContactsPage();
    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.userNameInput.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        contactsPage.contactsModule.click();

    }
    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String string) {

        Assert.assertEquals(string,Driver.getDriver().getTitle());

    }
}
