package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage extends BasePage {

    @FindBy(id = "cart_contents_container")
    WebElement cartContainerWebElm;

    public YourCartPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver waitForCartPageLoaded(){
        return this.waitForElementToBeVisible(cartContainerWebElm);
    }
}
