import com.saucedemo.common.providers.DataProviders;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.saucedemo.common.Constants.Urls;
import static com.saucedemo.common.Constants.LoginPageConstants;
import static org.testng.Assert.assertEquals;

public class TestAuth extends BaseTest {
    LoginPage loginPage;


    @BeforeMethod
    public void setupTest() {
        this.basePage.driver.manage().deleteAllCookies();
        this.basePage.driver.get(Urls.SAUCE_DEMO_BASE_URL);
        loginPage = new LoginPage(basePage.driver);
    }

    @Test(dataProvider = "auth-data", dataProviderClass = DataProviders.class)
    public void testPositiveAuth(String userName, String password) {
        this.loginPage.login(userName, password, true);
        assertEquals(basePage.getUrl(), Urls.INVENTORY_PAGE_URL, "Inventory page is not opened");
    }

    @Test
    @Parameters({"lockedUser"})
    public void testLockedUserAuth(String userName) {
        this.loginPage.login(userName, LoginPageConstants.COMMON_PASSWORD, false);
        assertEquals(this.loginPage.getErrorMessage(), LoginPageConstants.LOCKED_USER_TEXT,
                "Locked user login with problems.");
    }

    @Test(dataProvider = "wrong-auth-data", dataProviderClass = DataProviders.class)
    public void testIncorrectUserAuth(String userName, String password) {
        this.loginPage.login(userName, password, false);
        assertEquals(this.loginPage.getErrorMessage(), LoginPageConstants.WRONG_USER_TEXT,
                "Wrong user login workflow is not expected");
    }

}
