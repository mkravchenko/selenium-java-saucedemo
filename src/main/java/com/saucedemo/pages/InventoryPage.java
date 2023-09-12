package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class InventoryPage extends BasePage {

    final String addButtonLocator = ".//button[text()='Add to cart']";
    @FindBy(className = "title")

    private WebElement title;
    @FindBy(xpath = ".//*[@id='inventory_container']//img['inventory_item_img']")
    private List<WebElement> productImagesList;

    @FindBy(className = "inventory_item_desc")
    private List<WebElement> productDescriptionsList;

    @FindBy(className = "inventory_item")
    private List<WebElement> productsList;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productsNamesList;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> productsPricesList;

    @FindBy(xpath = addButtonLocator)
    private List<WebElement> addButtonsList;

    @FindBy(xpath = ".//button[text()='Remove']")
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

    public List<String> getListOfProductsImg() {
        return productImagesList.stream().map(el -> el.getAttribute("src")).collect(Collectors.toList());
    }

    public List<String> getListOfProductsDescriptions() {
        return productDescriptionsList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getListOfProductsNames() {
        return productsNamesList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<Float> getListOfProductsPrices() {
        List<String> priceList = productsPricesList.stream().map(WebElement::getText).toList();
        Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");
        List<Float> prices = new ArrayList<>();
        for (String itemPrice : priceList) {
            Matcher matcher = pattern.matcher(itemPrice);
            if (matcher.find()) {
                prices.add(Float.parseFloat(matcher.group(0)));
            }
        }
        return prices;
    }

    public void addAllProductsToCart() {
        addButtonsList.forEach(WebElement::click);
    }

    public void removeAllProductsFromCart() {
        removeButtonsList.forEach(WebElement::click);
    }

    public Optional<WebElement> getElementByText(String text) {
        return productsList.stream().filter(productEl -> productEl.findElement(By.className("inventory_item_name")).getText().equals(text)).findFirst();
    }

    public void sortProducts(String sortValue) {
        Select selectMenu = new Select(dropDownSort);
        selectMenu.selectByVisibleText(sortValue);
        this.waitForTextToBePresentInElement(currentSortOption, sortValue);

    }

    public InventoryPage addProductToCart(String productName) {
        Assert.assertTrue(this.getElementByText(productName).isPresent(),
                "Element with name" + productName + " should be present");
        this.getElementByText(productName).get().findElement(By.xpath(addButtonLocator)).click();
        return this;

    }

    public ProductDetailsPage pressProductByName(String productName) {
        Assert.assertTrue(this.getElementByText(productName).isPresent(), "Element should be present");
        this.getElementByText(productName).get().click();
        return PageFactory.initElements(this.driver, ProductDetailsPage.class);
    }
}
