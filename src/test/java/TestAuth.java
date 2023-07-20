import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


import static org.testng.Assert.assertEquals;

public class TestAuth extends BaseTest {

    @Test
    public void testAuth() {
        LoginPage loginPage = new LoginPage(basePage.driver);
        loginPage.login();
        WebDriverWait wait = new WebDriverWait(basePage.driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBe(By.xpath(".//*[@class='header_secondary_container']/span"), "Products"));
        assertEquals(basePage.getUrl(), "https://www.saucedemo.com/inventory.html", "Inventory page is not opened");
    }
}
