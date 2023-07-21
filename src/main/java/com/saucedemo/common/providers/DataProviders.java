package com.saucedemo.common.providers;

import org.testng.annotations.DataProvider;

import static com.saucedemo.common.Constants.LoginPageConstants.COMMON_PASSWORD;

public class DataProviders {

    @DataProvider(name = "auth-data")
    public static Object[][] authData() {
        return new Object[][]{
                {"standard_user", COMMON_PASSWORD},
                {"problem_user", COMMON_PASSWORD},
                {"performance_glitch_user", COMMON_PASSWORD}
        };
    }

    @DataProvider(name = "wrong-auth-data")
    public static Object[][] wrongAuthData() {
        return new Object[][]{
                {"some_user", COMMON_PASSWORD},
                {"standard_user", "somepassword"},
        };
    }



}
