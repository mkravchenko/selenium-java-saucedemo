package com.saucedemo.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver getDriver(String browser) {
        return switch (browser.toUpperCase()) {
            case "CHROME" -> new ChromeDriver();
            case "EDGE" -> new EdgeDriver();
            default -> new FirefoxDriver();
        };
    }
}
