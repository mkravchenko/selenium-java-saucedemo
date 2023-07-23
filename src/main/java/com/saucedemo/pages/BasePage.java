package com.saucedemo.pages;

import com.saucedemo.common.Constants.DefaultTimeouts;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(className = "shopping_cart_badge")
    WebElement shoppingCardBadge;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public int getNumberOfAddedProducts() {
        try {
            return Integer.parseInt(shoppingCardBadge.getText());
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public YourCartPage openMainMenu() {
        mainMenu.click();
        return new YourCartPage(driver);
    }

    public YourCartPage openShoppingCard() {
        shoppingCard.click();
        return new YourCartPage(driver);
    }

    public void wait_for_base_page_loaded() {
        this.waitForElementToBeVisible(mainMenu);
    }

    public WebDriver waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, DefaultTimeouts.EXPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOf(element));
        return driver;
    }

    public WebDriver waitForTextToBePresentInElement(WebElement element, String text) {
        new WebDriverWait(driver, DefaultTimeouts.EXPLICIT_WAIT)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
        return driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isPageLoaded(By by, String expectedText) {
        driver.findElement(by);
        return true;
    }
}