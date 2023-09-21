package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "login-button")
    public WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = ".//*[@data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password, boolean wait_for_bp_loaded) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.click();
        if (wait_for_bp_loaded) {
            this.wait_for_base_page_loaded();
        }
    }

    public String getErrorMessage() {
        return this.errorMessage.getText();
    }

}
