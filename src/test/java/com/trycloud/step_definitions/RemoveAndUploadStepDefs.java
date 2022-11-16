package com.trycloud.step_definitions;

import com.trycloud.pages.RemoveAndUploadPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveAndUploadStepDefs {

    RemoveAndUploadPage locatorPage = new RemoveAndUploadPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);


    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get("http://qa3.trycloud.net/");
        locatorPage.loginInput.sendKeys("user20");
        locatorPage.passwordInput.sendKeys("Userpass123");
        locatorPage.loginButton.click();


    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        wait.until(ExpectedConditions.elementToBeClickable(locatorPage.appMenu.get(0)));
        for (WebElement each : locatorPage.appMenu) {
            if (each.getAttribute("aria-label").equalsIgnoreCase(string)) {
                each.click();
                break;
            }
        }
//        wait.until(ExpectedConditions.visibilityOf(locatorPage.fileActions.get(0)));
        locatorPage.addToFavorites();
        Driver.getDriver().navigate().refresh();


    }

    @When("the users click action-icon from any file on the page to remove")
    public void the_users_click_action_icon_from_any_file_on_the_page_to_remove()  {

        for (WebElement each : locatorPage.fileActions){
            each.click();
            break;
        }
    }
    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
        for (WebElement each : locatorPage.fileActionsOptions){
            if (each.getText().equalsIgnoreCase(string)){
                each.click();
                break;
            }
        }
    }
    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {
        for (WebElement each : locatorPage.appNav){
            if (each.getText().equalsIgnoreCase(string)){
                each.click();
                break;
            }
        }
    }
    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        for (WebElement each : locatorPage.favorites){
            System.out.println(each.getText());
        }
        Assert.assertEquals(0, locatorPage.favorites.size());

    }

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        wait.until(ExpectedConditions.elementToBeClickable(locatorPage.addIcon));
        locatorPage.addIcon.click();

    }
    @When("users uploads file with the “upload file” option")
    public void users_uploads_file_with_the_upload_file_option() throws InterruptedException {
        Thread.sleep(3);
        locatorPage.fileUpload.sendKeys((System.getProperty("user.dir") + "/src/test/resources/uploadFiles/lol.txt"));
        wait.until(ExpectedConditions.invisibilityOf(locatorPage.progressBar));


    }
    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        String expectedName = "lol";
        String actualName = null;
        for (WebElement each : locatorPage.fileNames){
            if (each.getText().equals("lol")){
                actualName = each.getText();
            }
        }
        Assert.assertEquals("File upload assert failed", expectedName, actualName);


        for (WebElement each : locatorPage.fileActions){
            System.out.println(each.getText());
        }



    }

}
