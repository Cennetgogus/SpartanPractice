package com.spartantest.step_definitions;

import com.spartantest.pages.EtsyHomepage;
import com.spartantest.utilities.ConfigurationReader;
import com.spartantest.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Set;

public class EtsyTest {
    EtsyHomepage etsyHomepage = new EtsyHomepage();


    @Given("user is on Etsy page")
    public void user_is_on_etsy_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url2"));
    }
    @When("user search Gold Necklace")
    public void user_search_gold_necklace() {
    etsyHomepage.searchBox.sendKeys("Gold necklace");
    etsyHomepage.searchButton.click();
    }
    @When("user clicks on the first result")
    public void user_clicks_on_the_first_result() {
    etsyHomepage.firstResult.click();
    }
    @Then("user should see gold in product title")
    public void user_should_see_gold_in_product_title() {
     Object[] windowHandle =  Driver.getDriver().getWindowHandles().toArray();

       Driver.getDriver().switchTo().window(windowHandle[1].toString());

        String productTitle = etsyHomepage.productTitle.getText();
        System.out.println(productTitle);
    }


}
