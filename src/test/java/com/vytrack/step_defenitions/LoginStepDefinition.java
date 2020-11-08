package com.vytrack.step_defenitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class LoginStepDefinition {

    LoginPage  loginPage = new LoginPage();
    String expectedTitle = "";

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.getUrl();
    }

    @When("user logs in")
    public void user_logs_in() throws InterruptedException{
        loginPage.login();
        expectedTitle = loginPage.getExpectedTitle();
        Thread.sleep(2000);
    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {

        String actualTitleHomePage = loginPage.getPageSubTitleText().trim();
        Assert.assertEquals("title is not correct", expectedTitle   ,actualTitleHomePage);
        Driver.closeDriver();
    }


    //as a "driver" --
    // as "sales manager"
    // as "store manager"

    @When("user logs in as {string}")
    public void user_logs_in_as(String string) {
        loginPage.login(string);
        expectedTitle = loginPage.getExpectedTitle(string);


    }


    //  String string = "storemanager85";
    //  String string2 =  "wrong";
    //user logs in with "storemanager218" username and "wrong" password
    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
      loginPage.login(string,string2);
    }


    //    String expected = "Invalid user name or password."
    //    Then user verifies that "Invalid user name or password." message is displayed
    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {
       String actualResult = loginPage.getWarningMessageText();
        Assert.assertEquals(expected,actualResult);

    }


    @Then("user should see {string} page")
    public void userShouldSeePage(String string) {
        String actual = loginPage.getPageSubTitleText().trim();
        Assert.assertEquals("Page title is not correct!", string, actual);



    }
}
