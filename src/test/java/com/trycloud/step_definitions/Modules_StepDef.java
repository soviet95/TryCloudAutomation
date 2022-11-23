package com.trycloud.step_definitions;

import com.trycloud.pages.Modules_Page;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Modules_StepDef {

Modules_Page modules_page =new Modules_Page();

    @Given("user on the login page")
    public void user_on_the_login_page() {

    }

    @When("the users log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        modules_page.logIn();
    }
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedModules) {

        //list of actual elements
        Actions actions = new Actions(Driver.getDriver());

        //first find common locator for all modules/elements. FindElementS method will store them for you
        List<WebElement> allModules = modules_page.modules;

        for (WebElement each : allModules){
            actions.moveToElement(each).perform();
        }
        List<String> actualModules = new ArrayList<>();

        for(WebElement eachModule : allModules){
            actualModules.add(eachModule.getText());
        }


        Assert.assertEquals(expectedModules,actualModules);
        /*
        actualModules.add(modules_page.dashboardModule.getText());
        actualModules.add(modules_page.filesModule.getText());
        actualModules.add(modules_page.photosModule.getText());
        actualModules.add(modules_page.activityModule.getText());
        actualModules.add(modules_page.talkModule.getText());
        actualModules.add(modules_page.mailModule.getText());
        actualModules.add(modules_page.contactsModule.getText());
        actualModules.add(modules_page.circlesModule.getText());
        actualModules.add(modules_page.calendarModule.getText());
        actualModules.add(modules_page.calendarModule.getText());
        actualModules.add(modules_page.deckModule.getText());


         */





    }

}
