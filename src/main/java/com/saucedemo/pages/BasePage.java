package com.saucedemo.pages;

import com.saucedemo.common.Constants.DefaultTimeouts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    WebElement mainMenu;

    @FindBy(id = "shopping_cart_container")
    WebElement shoppingCard;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public YourCartPage openMainMenu() {
        mainMenu.click();
        return new YourCartPage(this.driver);
    }

    public YourCartPage openShoppingCard() {
        shoppingCard.click();
        return new YourCartPage(this.driver);
    }

    public WebDriver wait_for_base_page_loaded() {
        // TODO
        this.waitForElementToBeVisible(mainMenu);
        return this.driver;
    }

    public WebDriver waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(this.driver, DefaultTimeouts.EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return this.driver;
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }

    public boolean isPageLoaded(By by, String expectedText) {
        // TODO
        this.driver.findElement(by);
        return true;
    }
}
