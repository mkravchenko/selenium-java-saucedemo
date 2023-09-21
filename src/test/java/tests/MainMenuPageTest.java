package tests;

import com.saucedemo.common.AbstractWait;
import com.saucedemo.common.Constants;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.MainMenuPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MainMenuPageTest extends BaseTest {
    MainMenuPage mainManu;
    InventoryPage productPage;

    @BeforeClass(alwaysRun = true)
    public void setUpTestBeforeClass() {
        this.login();
        productPage = new InventoryPage(basePage.driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {
        mainManu = basePage.navigateToUrl(Constants.UrlsConstants.INVENTORY_PAGE_URL).openMainMenu();
    }

    @Test(priority = 1)
    public void testCheckElementsDisplayed() {
        Assert.assertTrue(mainManu.menuListItemsEl.stream().allMatch(WebElement::isDisplayed));
    }

    @Test(priority = 2)
    public void testCheckListNames() {
        List<String> itemNames = mainManu.getMenuItemsNames();
        Assert.assertEquals(itemNames, Constants.MainManuItems.NAMES_LIST);
    }

    @Test(priority = 3)
    public void testCheckAllItemsButtonWorkability() {
        productPage.openShoppingCard();
        mainManu.pressMenuElement(Constants.MainManuItems.ALL_ITEMS);
        Assert.assertFalse(mainManu.isMenuOpened());
        Assert.assertTrue(productPage.isPageLoaded());
    }

    @Test(priority = 4)
    public void testCheckResetButtonWorkability() {
        productPage.addAllProductsToCart();
        mainManu.pressMenuElement(Constants.MainManuItems.RESET_APP_STATE).closeMenu();
        int numberOfProducts = productPage.openShoppingCard().getNumberOfCartItems();
        Assert.assertEquals(numberOfProducts, 0);
    }

    @Test(priority = 5)
    public void testCheckAboutButtonWorkability() {
        mainManu.pressMenuElement(Constants.MainManuItems.ABOUT);
        Assert.assertEquals(basePage.getUrl(), "https://saucelabs.com/");
    }

    @Test(priority = 6)
    public void testCheckLogoutButtonWorkability() {
        mainManu.pressMenuElement(Constants.MainManuItems.LOGOUT);
        AbstractWait.waitForElementToBeVisible(loginPage.driver, loginPage.loginButton);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
