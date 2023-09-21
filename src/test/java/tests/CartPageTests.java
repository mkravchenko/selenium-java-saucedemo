package tests;

import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.YourCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartPageTests extends BaseTest {
    YourCartPage cartPage;

    @BeforeClass(alwaysRun = true, dependsOnMethods = "setUp")
    public void setUpTest() {
        this.login();
        cartPage = basePage.openShoppingCard();
        cartPage.waitForCartPageLoaded();
    }

    @Test
    public void testCheckCartIsEmpty() {
        Assert.assertEquals(cartPage.getNumberOfCartItems(), 0);
    }

    @Test(dependsOnMethods = "testCheckCartIsEmpty")
    public void testCheckAddedProduct() {
        InventoryPage inventoryPage = cartPage.pressContinueShoppingBtn();
        String productName = inventoryPage.getListOfProductsNames().get(0);
        inventoryPage.addProductToCart(productName);
        int numberOfProducts = basePage.openShoppingCard().getNumberOfCartItems();
        Assert.assertEquals(numberOfProducts, 1);

        String productNameInCart = cartPage.getListOfProductsNames().get(0);
        Assert.assertEquals(productNameInCart, productName);
    }
}
