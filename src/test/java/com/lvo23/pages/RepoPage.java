package com.lvo23.pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.SetValueOptions.withText;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.SelenideElement;

/**
 * @author Vlad Litvinov
 */
public class RepoPage {

    private final SelenideElement issueTab = $("#issues-tab"), issueTitle = $("#issue_2_link");

    public RepoPage issueTabClick() {

        issueTab.click();
        return this;
    }

    public RepoPage checkIssueTitle(String name) {

        issueTitle.shouldHave(text(name));
        return this;
    }

}
