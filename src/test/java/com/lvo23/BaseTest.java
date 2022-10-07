package com.lvo23;

import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;

/**
 * @author Vlad Litvinov
 */
public class BaseTest {

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";

    }

}
