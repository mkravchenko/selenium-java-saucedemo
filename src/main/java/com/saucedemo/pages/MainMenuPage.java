package com.saucedemo.pages;

import com.saucedemo.common.AbstractWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainMenuPage extends BasePage {


        @FindBy(xpath = ".//*[@class='bm-item-list']/a")
        public List<WebElement> menuListItemsEl;

        @FindBy(id = "react-burger-cross-btn")
        public WebElement closeMenuBtnEl;
//
//    @FindBy(xpath = ".//[@class='bm-item menu-item' and contains(text(), 'Sentiment']")
//    WebElement<WebElement> menuListItemsEl;

        public MainMenuPage(WebDriver driver) {
            super(driver);
        }

        public boolean isMenuOpened() {
            return closeMenuBtnEl.isDisplayed();
        }

        public MainMenuPage pressMenuElement(String itemName) {
            if (!this.isMenuOpened()) {
                this.openMainMenu();
            }
            WebElement itemEl = driver.findElement(By.xpath(".//*[@class='bm-item menu-item' and contains(text(), '" + itemName + "')]"));
            itemEl.click();
            return this;
        }

        public List<String> getMenuItemsNames() {
            List<String> menuItemsTexts = new ArrayList<>();
            for (WebElement s : menuListItemsEl) {
                menuItemsTexts.add(s.getText());
            }
            return menuItemsTexts;
        }

        public void closeMenu() {
            closeMenuBtnEl.click();
            AbstractWait.waitForElementToBeInvisibility(driver, closeMenuBtnEl);
        }
}
