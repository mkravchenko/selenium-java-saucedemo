import com.saucedemo.common.providers.DataProviders;
import com.saucedemo.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static com.saucedemo.common.Constants.ProductSortingValues.*;

public class InventoryPageTests extends BaseTest {
    InventoryPage productPage;

    @BeforeClass(alwaysRun = true)
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

    @Test(dataProvider = "sort-by-name-products", dataProviderClass = DataProviders.class)
    public void checkProductSortingByName(String sortBy) {
        List<String> expectedListOfProducts = productPage.getListOfProductsNames();
        if (sortBy.equals(NAME_A_TO_Z)) {
            Collections.sort(expectedListOfProducts);
        } else {
            expectedListOfProducts.sort(Collections.reverseOrder());
        }
        productPage.sortProducts(sortBy);
        List<String> productNamesAfterSorting = productPage.getListOfProductsNames();
        Assert.assertEquals(productNamesAfterSorting, expectedListOfProducts);
    }

    @Test(dataProvider = "sort-by-price-products", dataProviderClass = DataProviders.class)
    public void checkProductSortingByPrice(String sortBy) {
        List<Float> expectedListOfProducts = productPage.getListOfProductsPrices();
        if (sortBy.equals(PRICE_LOW_TO_HIGH)) {
            Collections.sort(expectedListOfProducts);
        } else {
            expectedListOfProducts.sort(Collections.reverseOrder());
        }
        productPage.sortProducts(sortBy);
        List<Float> productNamesAfterSorting = productPage.getListOfProductsPrices();
        Assert.assertEquals(productNamesAfterSorting, expectedListOfProducts);
    }
}
