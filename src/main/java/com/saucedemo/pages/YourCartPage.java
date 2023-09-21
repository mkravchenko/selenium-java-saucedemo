package com.saucedemo.pages;

import com.saucedemo.common.AbstractWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourCartPage extends InventoryPage {

    @FindBy(id = "cart_contents_container")
    WebElement cartContainerWebElm;

    @FindBy(xpath = ".//div[@class=\"cart_item\"]")
    List<WebElement> cartItems;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingBtn;


    public YourCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebDriver waitForCartPageLoaded() {
        return AbstractWait.waitForElementToBeVisible(driver, cartContainerWebElm);
    }

    public int getNumberOfCartItems() {
        return cartItems.size();
    }

    public InventoryPage pressContinueShoppingBtn() {
        continueShoppingBtn.click();
        return new InventoryPage(this.driver);
    }
}
