package com.saucedemo.common;

import java.time.Duration;

public class Constants {
    public static class DefaultTimeouts {
        public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(5);
        public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);
    }

}
