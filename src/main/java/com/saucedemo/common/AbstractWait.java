package com.saucedemo.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractWait {

    public static WebDriver waitForElementToBeVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Constants.DefaultTimeouts.EXPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOf(element));
        return driver;
    }

    public static void waitForElementToBeInvisibility(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Constants.DefaultTimeouts.EXPLICIT_WAIT)
                .until(ExpectedConditions.invisibilityOf(element));
    }

}
