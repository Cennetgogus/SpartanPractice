package com.spartantest.pages;

import com.spartantest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebData {

    public WebData(){ // this called constructor
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameBox;

    @FindBy(css = "button[id='search']")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@id='view_spartan_7']")
    public WebElement viewButton;

    @FindBy(css = "#phone")
    public WebElement phoneNumber;



}
