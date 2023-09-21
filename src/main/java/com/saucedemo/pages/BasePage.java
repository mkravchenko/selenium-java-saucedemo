package com.saucedemo.pages;

import com.saucedemo.common.AbstractWait;
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

    public int getNumberOfAddedProducts() {
        try {
            return Integer.parseInt(shoppingCardBadge.getText());
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public MainMenuPage openMainMenu() {
        mainMenu.click();
        return new MainMenuPage(driver);
    }

    public YourCartPage openShoppingCard() {
        shoppingCard.click();
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.waitForCartPageLoaded();
        return yourCartPage;
    }

    public void wait_for_base_page_loaded() {
        AbstractWait.waitForElementToBeVisible(driver, mainMenu);
    }

    public WebDriver waitForTextToBePresentInElement(WebElement element, String text) {
        new WebDriverWait(driver, DefaultTimeouts.EXPLICIT_WAIT)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
        return driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public BasePage navigateToUrl(String url) {
        driver.get(url);
        return this;
    }

    public BasePage navigateBack() {
        driver.navigate().back();
        return this;
    }

    public BasePage deleteCookie() {
        driver.manage().deleteAllCookies();
        return this;
    }
}