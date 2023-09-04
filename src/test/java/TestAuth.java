import com.saucedemo.common.providers.DataProviders;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.saucedemo.common.Constants.LoginPageConstants;
import static com.saucedemo.common.Constants.UrlsConstants;
import static org.testng.Assert.assertEquals;

public class TestAuth extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        basePage.driver.manage().deleteAllCookies();
        basePage.driver.get(UrlsConstants.SAUCE_DEMO_BASE_URL);
        loginPage = new LoginPage(basePage.driver);
    }

    @Test(dataProvider = "auth-data", dataProviderClass = DataProviders.class)
    public void testPositiveAuth(String userName, String password) {
        loginPage.login(userName, password, true);
        assertEquals(basePage.getUrl(), UrlsConstants.INVENTORY_PAGE_URL, "Inventory page is not opened");
    }

    @Test
    @Parameters({"lockedUser"})
    public void testLockedUserAuth(@Optional("locked_out_user") String userName) {
        loginPage.login(userName, LoginPageConstants.COMMON_PASSWORD, false);
        assertEquals(loginPage.getErrorMessage(), LoginPageConstants.LOCKED_USER_TEXT,
                "Locked user login with problems.");
    }

    @Test(dataProvider = "wrong-auth-data", dataProviderClass = DataProviders.class)
    public void testIncorrectUserAuth(String userName, String password) {
        loginPage.login(userName, password, false);
        assertEquals(loginPage.getErrorMessage(), LoginPageConstants.WRONG_USER_TEXT,
                "Wrong user login workflow is not expected");
    }
}
