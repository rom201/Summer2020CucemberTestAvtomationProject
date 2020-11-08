package com.vytrack.step_defenitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepDefenitions {


    // we dont know for which page this methods belongs

    //LoginPage loginPage = new LoginPage();
    //we refer to the Base page


    BasePage basePage = new LoginPage();


    @Given("user navigates to {string} and {string}")
    public void user_navigates_to_and(String string, String string2) {
        basePage.navigateTo(string,string2);

    }

    @When("user clicks on save and close button")
    public void user_clicks_on_save_and_close_button() {
        basePage.clickSaveAndClose();
    }




}
