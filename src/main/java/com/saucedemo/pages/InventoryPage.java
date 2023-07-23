package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    @FindBy(xpath = ".//*[@class='header_secondary_container']/span")
    private WebElement title;

    @FindBy(className = "inventory_item_img")
    private WebElement productImage;

    @FindBy(className = "inventory_item_name")
    private WebElement productName;

    @FindBy(className = "inventory_item_desc")
    private WebElement productDescription;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCart;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeFromCart;

    @FindBy(id = "inventory_item_price")
    private WebElement price;

    @FindBy(className = "inventory_item")
    private List<WebElement> productsList;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productsListNames;

    @FindBy(xpath = ".//*[@class='inventory_item']//button[text()='Add to cart']")
    private List<WebElement> addButtonsList;

    @FindBy(xpath = ".//*[@class='inventory_item']//button[text()='Remove']")
    private List<WebElement> removeButtonsList;

    @FindBy(xpath = ".//span[@class='select_container']/span[@class='active_option']")
    private WebElement currentSortOption;

    @FindBy(className = "product_sort_container")
    private WebElement dropDownSort;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public int getProductsNumber() {
        return productsList.size();
    }
    public List<String> getListOfProductsNames() {
        return productsListNames.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void addAllProductsToCart() {
        addButtonsList.forEach(WebElement::click);
    }

    public void removeAllProductsFromCart() {
        removeButtonsList.forEach(WebElement::click);
    }

    public Optional<WebElement> getElementByText(String text) {
        return productsList.
                stream().
                filter(productEl -> productEl.findElement(By.className("inventory_item_name"))
                        .getText().equals(text))
                .findFirst();
    }

    public void sortProducts(String sortValue){
        Select selectMenu = new Select(dropDownSort);
        selectMenu.selectByVisibleText(sortValue);
        this.waitForTextToBePresentInElement(currentSortOption, sortValue);

    }
}
