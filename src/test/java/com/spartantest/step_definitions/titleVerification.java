package com.spartantest.step_definitions;

import com.spartantest.pages.HomePage;
import com.spartantest.utilities.ConfigurationReader;
import com.spartantest.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

public class titleVerification {
    HomePage homePage = new HomePage();

    @Given("User is in the spartan homepage")
    public void user_is_in_the_spartan_homepage() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    @When("User clicks the web data")
    public void user_clicks_the_web_data() {
    homePage.webDataIcon.click();

    }
    @Then("User see the title as All Spartan")
    public void user_see_the_title_as_all_spartan() {
       String title = Driver.getDriver().getTitle();
        assertEquals(title, "All Spartan", "Its not a match");
    }


}
