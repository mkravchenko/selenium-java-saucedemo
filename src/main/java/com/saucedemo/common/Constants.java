package com.saucedemo.common;

import java.time.Duration;

public class Constants {
    public static class Urls {
        public static final String SAUCE_DEMO_BASE_URL = "https://www.saucedemo.com";
        public static final String INVENTORY_PAGE_URL = SAUCE_DEMO_BASE_URL + "/inventory.html";
    }
    public static class DefaultTimeouts {
        public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(5);
        public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);
    }

    public static class LoginPageConstants {
        public static final String COMMON_PASSWORD = "secret_sauce";
        public static final String LOCKED_USER_TEXT = "Epic sadface: Sorry, this user has been locked out.";
        public static final String WRONG_USER_TEXT = "Epic sadface: Username and password do not match any user in this service";
    }
}
