package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login() {
        // TODO: move to configs
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        this.wait_for_base_page_loaded();
        return this;
    }


}
