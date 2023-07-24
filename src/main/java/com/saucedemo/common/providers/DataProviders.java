package com.saucedemo.common.providers;

import org.testng.annotations.DataProvider;
import java.util.Collection;

import static com.saucedemo.common.Constants.LoginPageConstants.*;
import static com.saucedemo.common.Constants.ProductSortingValues.*;

public class DataProviders {

    @DataProvider(name = "auth-data")
    public static Object[][] authData() {
        return new Object[][]{
                {STANDARD_USER, COMMON_PASSWORD},
                {PROBLEM_USER, COMMON_PASSWORD},
                {PERFORMANCE_GLITCH_USER, COMMON_PASSWORD}
        };
    }

    @DataProvider(name = "wrong-auth-data")
    public static Object[][] wrongAuthData() {
        return new Object[][]{
                {"some_user", COMMON_PASSWORD},
                {"standard_user", "somepassword"},
        };
    }

    @DataProvider(name = "sort-by-name-products")
    public static Object[][] sortByNameData() {
        return new Object[][]{
                {NAME_Z_TO_A},
                {NAME_A_TO_Z}
        };
    }

    @DataProvider(name = "sort-by-price-products")
    public static Object[][] sortByPriceData() {
        return new Object[][]{
                {PRICE_LOW_TO_HIGH},
                {PRICE_HIGH_TO_LOW}
        };
    }

}
