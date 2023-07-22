package com.saucedemo.common.providers;

import org.testng.annotations.DataProvider;

import static com.saucedemo.common.Constants.LoginPageConstants.*;

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



}
