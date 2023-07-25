package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenuPage extends BasePage {

    @FindBy(className = "bm-menu-wrap")
    WebElement menuContainerElm;

    public MainMenuPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver waitForCartLoaded(){
        return this.waitForElementToBeVisible(menuContainerElm);
    }
}
