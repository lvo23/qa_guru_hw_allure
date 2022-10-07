package com.lvo23.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;

/**
 * @author Vlad Litvinov
 */
public class MainPage {

    private final SelenideElement searchInput = $(".header-search-input");

    public MainPage openPage() {

        open("/");

        return this;
    }

    public MainPage searchInputClick() {

        searchInput.click();
        return this;
    }

    public MainPage searchInputSetValue(String repoName) {

        searchInput.setValue(repoName);
        return this;
    }

    public MainPage searchInputSubmit() {

        searchInput.submit();
        return this;
    }

}
