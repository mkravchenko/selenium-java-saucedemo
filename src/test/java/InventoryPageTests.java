import com.saucedemo.common.MiscUtils;
import com.saucedemo.common.providers.DataProviders;
import com.saucedemo.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

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

    @Test
    public void checkDescriptionVisible() {
        List<String> descriptions = productPage.getListOfProductsDescriptions();
        boolean isEmptyDescription = descriptions.stream().allMatch(item -> (!item.isEmpty() && !item.isBlank()));
        Assert.assertTrue(isEmptyDescription, "Description can't be empty");
    }

    @Test(dataProvider = "sort-by-name-products", dataProviderClass = DataProviders.class)
    public void checkProductSortingByName(String sortBy, boolean isReversSearch) {
        List<String> expectedListOfProducts = productPage.getListOfProductsNames();
        expectedListOfProducts = (List<String>) MiscUtils.sortList(expectedListOfProducts, isReversSearch);
        productPage.sortProducts(sortBy);
        List<String> productNamesAfterSorting = productPage.getListOfProductsNames();
        Assert.assertEquals(productNamesAfterSorting, expectedListOfProducts,
                "Sorting by '" + sortBy + "' sorts with errors");
    }

    @Test(dataProvider = "sort-by-price-products", dataProviderClass = DataProviders.class)
    public void checkProductSortingByPrice(String sortBy, boolean isReversSearch) {
        List<Float> expectedListOfProducts = productPage.getListOfProductsPrices();
        expectedListOfProducts = (List<Float>) MiscUtils.sortList(expectedListOfProducts, isReversSearch);
        productPage.sortProducts(sortBy);
        List<Float> productNamesAfterSorting = productPage.getListOfProductsPrices();
        Assert.assertEquals(productNamesAfterSorting, expectedListOfProducts,
                "Sorting by '" + sortBy + "' sorts with errors");
    }
}
