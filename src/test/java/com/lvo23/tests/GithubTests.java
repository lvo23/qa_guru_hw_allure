package com.lvo23.tests;

import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lvo23.BaseTest;
import com.lvo23.pages.MainPage;
import com.lvo23.pages.RepoPage;
import com.lvo23.pages.SearchPage;
import com.lvo23.steps.WebSteps;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * @author Vlad Litvinov
 */
public class GithubTests extends BaseTest {

    private static final String REPO_LINK = "lvo23/qa_guru_hw_demoqa";

    private static final String ISSUE_NAME = "Test issue";

    MainPage mainPage = new MainPage();

    SearchPage searchPage = new SearchPage();

    RepoPage repoPage = new RepoPage();

    WebSteps webSteps = new WebSteps();

    @Test
    @DisplayName("Проверить название issue – тест selenide")
    public void checkNameIssueSelenide() {

        mainPage.openPage().searchInputClick().searchInputSetValue(REPO_LINK).searchInputSubmit();
        searchPage.repoLinkClick();
        repoPage.issueTabClick().checkIssueTitle(ISSUE_NAME);
    }

    @Test
    @DisplayName("Проверить название issue – тест с lamda-функцией step")
    public void checkNameIssueLambdaOpen() {

        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Ищем в поиске репозиторий " + REPO_LINK, () -> {
            mainPage.searchInputClick().searchInputSetValue(REPO_LINK).searchInputSubmit();
        });

        step("В результатах поиска кликаем по ссылке репозитория " + REPO_LINK, () -> {
            searchPage.repoLinkClick();
        });

        step("Нажимаем на таб Issues", () -> {
            repoPage.issueTabClick();
        });

        step("Проверяем название issue " + ISSUE_NAME, () -> {
            repoPage.checkIssueTitle(ISSUE_NAME);
        });
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Создать issue")
    @Owner("litvinov_vo")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверить название issue – тест с аннотацией @Step")
    public void checkNameIssueAnnotationStep() {

        webSteps.openMainPage();
        webSteps.searchRepo(REPO_LINK);
        webSteps.clickOnLinkRepo();
        webSteps.clickIssueTab();
        webSteps.checkIssueTitle(ISSUE_NAME);
    }

}
