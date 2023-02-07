package org.example.homework6;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Story("Travel WebSite Tests")
public class TravelWebsitePageTest extends AbstractTest {

    @Test
    @DisplayName("Search for a tour by parameters")
    @Description("Country selection - Period selection by dates")
    @Link("https://youtravel.me/")
    @Issue("https://youtravel.me/tours/")
    @TmsLink("https://www.atlassian.com/ru/software/jira")
    @Severity(SeverityLevel.CRITICAL)
    void tourSearchTest() throws IOException {
        TourSearchPage tourSearchPage = new TourSearchPage(getDriver());
        tourSearchPage
                .clickInputCountry()
                .clickCountrySelection();
        saveScreen("Выбор страны");
        tourSearchPage
                .clickInputDate()
                .clickPeriod()
                .clickPeriodSelection();
        saveScreen("Выбор периода по датам");
        tourSearchPage.clickButtonSearch();
        saveScreen("Поиск тура по выбранным параметрам");
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://youtravel.me/tours/"));
    }

    private void saveScreen(String name) throws IOException {
        File file = MyUtils.makeScreenshot(getDriver(),name + " " + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
    }

    @Step("Степ 1")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Test
    @DisplayName("Opening the tour page in a new window (tab)")
    @Description("Choosing a tour - Opening a page with a tour")
    @Link("https://youtravel.me/")
    @TmsLink("https://www.atlassian.com/ru/software/jira")
    @Severity(SeverityLevel.CRITICAL)
    void openingTourTest() throws InterruptedException, IOException {
        TourSearchPage tourSearchPage = new TourSearchPage(getDriver());
        tourSearchPage.clickJourneys().clickAllJourneys();
        Assertions.assertDoesNotThrow(() -> tourSearchPage.cardSelection(4));
        saveScreen("Открытие страницы тура в новом окне (вкладке)");
    }

    @Test
    @DisplayName("Filtering the search for tours by rating")
    @Description("Opening an Expert rating - Choosing a rating")
    @Link("https://youtravel.me/")
    @Issue("https://youtravel.me/tours/")
    @TmsLink("https://www.atlassian.com/ru/software/jira")
    @Severity(SeverityLevel.NORMAL)
    void filteringTourRatingTest() throws IOException {
        FilteringSearchPage filteringSearchPage = new FilteringSearchPage(getDriver());
        filteringSearchPage.clickAllJourneys().clickExpertRating();
        Assertions.assertDoesNotThrow(() -> filteringSearchPage.ratingSelection(4));
        saveScreen("Фильтрация поиска туров по рейтингу");
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://youtravel.me/tours/"));
    }

    @Test
    @DisplayName("Opening the press page in a new window (tab)")
    @Link("https://youtravel.me/")
    @Issue("https://pro.rbc.ru/news/60a67ae59a794731f96d3669")
    @TmsLink("https://www.atlassian.com/ru/software/jira")
    @Severity(SeverityLevel.MINOR)
    void viewingPress() throws InterruptedException, IOException {
        AdditionalFeaturesMainPage additionalFeaturesMainPage = new AdditionalFeaturesMainPage(getDriver());
        additionalFeaturesMainPage.clickPressPortal();
        saveScreen("Открытие страницы прессы в новом окне (вкладке)");
        String urlPress = "https://pro.rbc.ru/news/60a67ae59a794731f96d3669";
        Assertions.assertEquals(urlPress, getDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Selection of work on the resource (manager)")
    @Description("Positions of specialists - Manager")
    @Link("https://youtravel.me/")
    @Issue("https://ytme.atlassian.net/wiki/spaces/TM/pages/2351923222/US+marketing+manager")
    @TmsLink("https://www.atlassian.com/ru/software/jira")
    @Severity(SeverityLevel.NORMAL)
    void jobSelection() throws InterruptedException, IOException {
        AdditionalFeaturesMainPage additionalFeaturesMainPage = new AdditionalFeaturesMainPage(getDriver());
        additionalFeaturesMainPage.clickWorkWithUs().clickOpenPositions();
        saveScreen("Позиции специалистов");
        additionalFeaturesMainPage.clickPositionMarketingManager();
        saveScreen("Подбор работы на ресурсе (менеджер)");
        String urlJob = "https://ytme.atlassian.net/wiki/spaces/TM/pages/2351923222/US+marketing+manager";
        Assertions.assertEquals(urlJob, getDriver().getCurrentUrl());;
    }

    @Test
    @DisplayName("Request help from support for the entered parameters")
    @Link("https://youtravel.me/")
    @Issue("https://youtravel.me/support/Keshbek20mir")
    @TmsLink("https://www.atlassian.com/ru/software/jira")
    @Severity(SeverityLevel.NORMAL)
    void support() throws InterruptedException, IOException {
        AdditionalFeaturesMainPage additionalFeaturesMainPage = new AdditionalFeaturesMainPage(getDriver());
        additionalFeaturesMainPage.clickHelp().clickSelectSupport();
        saveScreen("Помощь у поддержки");
        additionalFeaturesMainPage.clickRequest("Акция Кешбэк 20% по карте МИР");
        saveScreen("Запрос помощи у поддержки по введеным параметрам (Акция Кешбэк 20% по карте МИР)");
        String urlRequest = "https://youtravel.me/support/Keshbek20mir";
        Assertions.assertEquals(urlRequest, getDriver().getCurrentUrl());
    }
}
