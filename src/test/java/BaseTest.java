import com.saucedemo.common.Constants.DefaultTimeouts;
import com.saucedemo.pages.BasePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected BasePage basePage;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        basePage = PageFactory.initElements(new ChromeDriver(), BasePage.class);
        basePage.driver.manage().timeouts().implicitlyWait(DefaultTimeouts.IMPLICIT_WAIT);
        basePage.driver.manage().window().maximize();
        basePage.driver.get("https://www.saucedemo.com/");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        basePage.driver.close();
    }
}
