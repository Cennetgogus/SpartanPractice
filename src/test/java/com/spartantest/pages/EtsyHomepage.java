package com.spartantest.pages;

import com.spartantest.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsyHomepage {
    public EtsyHomepage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

@FindBy(xpath = "//input[@id='global-enhancements-search-query']")
    public WebElement searchBox;
    //WebElement getSearchBox = driver.getElement(By.ByXPath("//input[@id='global-enhancements-search-query']"))
@FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement searchButton;
@FindBy(xpath = "(//img[@data-listing-card-listing-image])[5]")
    public WebElement firstResult;
@FindBy(xpath = "//div[@class='wt-mb-xs-2']/child::h1")
    public WebElement productTitle;

}
