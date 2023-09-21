package com.saucedemo.common;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Constants {
    public static class UrlsConstants {
        public static final String SAUCE_DEMO_BASE_URL = "https://www.saucedemo.com";
        public static final String INVENTORY_PAGE_URL = SAUCE_DEMO_BASE_URL + "/inventory.html";
    }

    public static class DefaultTimeouts {
        public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(5);
        public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);
    }

    public static class LoginPageConstants {

        public static final String STANDARD_USER = "standard_user";
        public static final String PROBLEM_USER = "problem_user";
        public static final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";
        public static final String COMMON_PASSWORD = "secret_sauce";
        public static final String LOCKED_USER_TEXT = "Epic sadface: Sorry, this user has been locked out.";
        public static final String WRONG_USER_TEXT = "Epic sadface: Username and password do not match any user in this service";
    }

    public static class ProductSortingValues {
        public static final String NAME_A_TO_Z = "Name (A to Z)";
        public static final String NAME_Z_TO_A = "Name (Z to A)";
        public static final String PRICE_LOW_TO_HIGH = "Price (low to high)";
        public static final String PRICE_HIGH_TO_LOW = "Price (high to low)";
    }

    public static class MainManuItems {
        public static final String ALL_ITEMS = "All Items";
        public static final String ABOUT = "About";
        public static final String LOGOUT = "Logout";
        public static final String RESET_APP_STATE = "Reset App State";
        public static final List<String> NAMES_LIST = Arrays.asList(ALL_ITEMS, ABOUT, LOGOUT, RESET_APP_STATE);
    }
}
