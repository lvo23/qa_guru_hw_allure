package com.lvo23.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.codeborne.selenide.WebDriverRunner;
import com.lvo23.pages.MainPage;
import com.lvo23.pages.RepoPage;
import com.lvo23.pages.SearchPage;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

/**
 * @author Vlad Litvinov
 */
public class WebSteps {

    MainPage mainPage = new MainPage();

    SearchPage searchPage = new SearchPage();

    RepoPage repoPage = new RepoPage();


    @Step("Открываем главную страницу")
    public void openMainPage() {
        mainPage.openPage();
    }

    @Step("Ищем в поиске репозиторий")
    public void searchRepo(String repoName) {
        mainPage.searchInputClick().searchInputSetValue(repoName).searchInputSubmit();
    }

    @Step("В результатах поиска кликаем по ссылке репозитория")
    public void clickOnLinkRepo() {
        searchPage.repoLinkClick();

    }

    @Step("Нажимаем на таб Issues")
    public void clickIssueTab() {
        repoPage.issueTabClick();

    }

    @Step("Проверяем название issue")
    public void checkIssueTitle(String issueTitle) {
        repoPage.checkIssueTitle(issueTitle);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
