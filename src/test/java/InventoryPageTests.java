import com.saucedemo.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.saucedemo.common.Constants.ProductSortingValues.NAME_Z_TO_A;

public class InventoryPageTests extends BaseTest {
    InventoryPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {
        this.login();
        productPage = new InventoryPage(basePage.driver);
    }

    @Test
    public void checkAddRemoveButtonsClickable() {
        productPage.addAllProductsToCart();
        Assert.assertEquals(basePage.getNumberOfAddedProducts(), productPage.getProductsNumber(),
                "Number of added elements not match");

        productPage.removeAllProductsFromCart();
        Assert.assertEquals(basePage.getNumberOfAddedProducts(), 0,
                "All products should be removed");

    }

    // TODO: add DataProviders
    // TODO: add Test for sorting by price
    @Test
    public void checkProductSortingByName() {
        List<String> expectedListOfProducts = productPage.getListOfProductsNames();
        expectedListOfProducts.sort(Collections.reverseOrder());
        productPage.sortProducts(NAME_Z_TO_A);
        List<String> productNamesAfterSorting = productPage.getListOfProductsNames();
        Assert.assertEquals(productNamesAfterSorting, expectedListOfProducts);
    }
}
