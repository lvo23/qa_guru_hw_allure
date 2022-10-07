package com.lvo23.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lvo23.BaseTest;
import com.lvo23.pages.MainPage;
import com.lvo23.pages.RepoPage;
import com.lvo23.pages.SearchPage;

/**
 * @author Vlad Litvinov
 */
public class GithubTests extends BaseTest {

    private static final String REPO_LINK = "lvo23/qa_guru_hw_demoqa";
    private static final String ISSUE_NAME = "Test issue";


    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    RepoPage repoPage = new RepoPage();

    @Test
    @DisplayName("Проверить название issue – тест selenide")
    public void checkNameIssue() {
        mainPage.openPage().searchInputClick().searchInputSetValue(REPO_LINK).searchInputSubmit();
        searchPage.repoLinkClick();
        repoPage.issueTabClick().checkIssueTitle(ISSUE_NAME);
    }

}
