package com.lvo23.pages;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.SelenideElement;

/**
 * @author Vlad Litvinov
 */
public class SearchPage {

    private static final String REPO_LINK = "lvo23/qa_guru_hw_demoqa";

    private final SelenideElement repoLink = $(linkText(REPO_LINK));

    public SearchPage repoLinkClick() {

        repoLink.click();
        return this;
    }

}
