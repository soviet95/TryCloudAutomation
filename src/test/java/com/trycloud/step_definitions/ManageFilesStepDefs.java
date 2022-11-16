package com.trycloud.step_definitions;

import com.trycloud.pages.ManageFilesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ManageFilesStepDefs {
    ManageFilesPage filesPage = new ManageFilesPage();
    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
    }

    @When("User enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String arg0, String arg1) {
    }

    @And("User clicks the login button")
    public void userClicksTheLoginButton() {
    }

    @And("User is at the dashboard page")
    public void userIsAtTheDashboardPage() {
    }

    // US-7, TC1 -----------------------------------------------------------------------------------------------
    @When("the user clicks the Files module")
    public void theUserClicksTheFilesModule() {
        filesPage.filesModule.click();
    }

    @When("user clicks the add icon on the top")
    public void user_clicks_the_add_icon_on_the_top() {
        filesPage.addIcon.click();

    }

    @When("user clicks the new folder")
    public void user_clicks_the_new_folder() {
        filesPage.newFolderIcon.click();

    }

    @When("user write a folder {string}")
    public void user_write_a_folder(String folderName) {
        filesPage.newFolderInput.sendKeys(folderName);

    }

    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        filesPage.submitBtn.click();

    }

    @Then("Verify the folder {string} is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page(String expectedFolderName) {
       ManageFilesPage.waitFor(2);
        for (WebElement eachFolder : filesPage.fileAndFoldersList) {
            System.out.println(eachFolder.getText());

        }
        boolean isFolderExists = false;
        for (WebElement each : filesPage.fileAndFoldersList) {
            if (each.getText().equals(expectedFolderName)) {
                isFolderExists = true;
                filesPage.deleteFolder(each);
                ManageFilesPage.waitFor(1);

            }
        }
        Assert.assertTrue(isFolderExists);

    }

    @And("user choose a folder from the page")
    public void userChooseAFolderFromThePage() {

        filesPage.firstFolder.click();
        ManageFilesPage.waitFor(2);

    }

    String expectedFileName = "test-file";

    @When("the user uploads a file with the upload file option")
    public void theUserUploadsAFileWithTheUploadFileOption() {

       ManageFilesPage.waitFor(2);
        filesPage.inputButton.sendKeys("C:\\Users\\azizj\\Desktop\\" + expectedFileName + ".txt");


        filesPage.addIcon.click();
//        Actions actions = new Actions(Driver.getDriver());
//        actions.clickAndHold(filesPage.addIcon);
//        filesPage.uploadFileAction.click();
//        BrowserUtils.waitFor(1);
//        filesPage.uploadFileAction.sendKeys("C:\\Users\\azizj\\Desktop\\Test.txt" + Keys.ENTER);
//        BrowserUtils.waitForInvisibility(filesPage.uploadProgressBar);

        ManageFilesPage.waitFor(2);
    }

    @Then("Verify the file is displayed on the page")
    public void verifyTheFileIsDisplayedOnThePage() {
        filesPage.verifyFileName(filesPage.fileName, expectedFileName);

    }


}
