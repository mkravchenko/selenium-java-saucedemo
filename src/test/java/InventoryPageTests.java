import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.saucedemo.common.Constants.LoginPageConstants.COMMON_PASSWORD;
import static com.saucedemo.common.Constants.LoginPageConstants.STANDARD_USER;

public class InventoryPageTests extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {
        this.login();
    }

    @Test
    public void checkAddRemoveButtonsClickable() {
        InventoryPage productPage = new InventoryPage(basePage.driver);
        productPage.addAllProductsToCart();
        Assert.assertEquals(basePage.getNumberOfAddedProducts(), productPage.getProductsNumber(),
                "Number of added elements not match");

        productPage.removeAllProductsFromCart();
        Assert.assertEquals(basePage.getNumberOfAddedProducts(), 0,
                "All products should be removed");

    }
}
