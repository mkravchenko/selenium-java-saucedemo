package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDetailsPage extends BasePage {

    @FindBy(id = "back-to-products")
    private WebElement backToProductsButtons;

    @FindBy(className = "inventory_details_img")
    private WebElement productDetailsImg;

    @FindBy(className = "inventory_details_name")
    private List<WebElement> productName;

    @FindBy(className = "inventory_details_desc")
    private List<WebElement> productDescription;

    @FindBy(className = "inventory_details_price")
    private List<WebElement> productPrice;

    @FindBy(xpath = ".//*[@class='inventory_details_desc_container']//button")
    private List<WebElement> addRemoveBtn;


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public InventoryPage pressBackToProducts() {
        backToProductsButtons.click();
        return PageFactory.initElements(this.driver, InventoryPage.class);
    }
}
