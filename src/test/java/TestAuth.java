import com.saucedemo.common.providers.DataProviders;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class TestAuth extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void setupTest() {
        this.basePage.driver.manage().deleteAllCookies();
        this.basePage.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(basePage.driver);
    }

    @Test(dataProvider = "auth-data", dataProviderClass = DataProviders.class)
    public void testPositiveAuth(String userName, String password) {
        this.loginPage.login(userName, password, true);
        assertEquals(basePage.getUrl(), "https://www.saucedemo.com/inventory.html", "Inventory page is not opened");
    }

    @Test
    @Parameters({"lockedUser"})
    public void testLockedUserAuth(String userName) {
        this.loginPage.login(userName, DataProviders.COMMON_PASSWORD, false);
        assertEquals(this.loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.",
                "Locked user login with problems " + Arrays.toString(Arrays.stream(DataProviders.wrongAuthData()).toArray()));
    }

    @Test(dataProvider = "wrong-auth-data", dataProviderClass = DataProviders.class)
    public void testIncorrectUserAuth(String userName, String password) {
        this.loginPage.login(userName, password, false);
        assertEquals(this.loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service",
                "Wrong user login workflow is not expected");
    }

}
