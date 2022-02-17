package com.spartantest.step_definitions;

import com.spartantest.pages.WebData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class UserVerification {

    WebData webData = new WebData();

    @And("User writes Hershel and search")
    public void user_writes_hershel_and_search() {
    webData.nameBox.sendKeys("Hershel");
    webData.searchButton.click();

    }

    @And("User clicks the view button")
    public void user_clicks_the_view_button() {
    webData.viewButton.click();

    }

    @Then("User should see the phone number as {long}")
    public void user_should_see_the_phone_number_as(long expectedNumber) {
    String actualNumber = webData.phoneNumber.getAttribute("value");
    String expectedNum = String.valueOf(expectedNumber);
    assertEquals(actualNumber, expectedNum, "its not matching");
    }


}
