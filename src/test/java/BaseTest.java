import com.saucedemo.common.Constants.DefaultTimeouts;
import com.saucedemo.common.Constants.LoginPageConstants;
import com.saucedemo.common.Constants.UrlsConstants;
import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected BasePage basePage;
    protected LoginPage loginPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        basePage = PageFactory.initElements(new ChromeDriver(), BasePage.class);
        basePage.driver.manage().timeouts().implicitlyWait(DefaultTimeouts.IMPLICIT_WAIT);
        basePage.driver.manage().window().maximize();
        basePage.driver.get(UrlsConstants.SAUCE_DEMO_BASE_URL);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        basePage.driver.close();
    }

    public LoginPage login() {
        loginPage = new LoginPage(basePage.driver);
        loginPage.login(LoginPageConstants.STANDARD_USER, LoginPageConstants.COMMON_PASSWORD, true);
        return loginPage;
    }
}
