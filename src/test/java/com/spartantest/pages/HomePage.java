package com.spartantest.pages;

import com.spartantest.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//i[@class='fas fa-home']")
    public WebElement homeIcon;

    @FindBy(xpath = "//i[@class='fas fa-users']")
    public WebElement webDataIcon;

    @FindBy(xpath = "//i[@class='fas fa-file-code']")
    public WebElement apiIcon;

    @FindBy(xpath = "//i[@class='fas fa-database']")
    public WebElement dataIcon;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement navIcon;

    // public static void main(String[] args){
    // WebElement homeIcon = Driver.getDriver().findElement(By.xpath("//i[@class='fas fa-home']"));


}


