package org.example.homework6;

import org.example.homework5.TravelWebsiteTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TravelWebsitePageTest extends AbstractTest {

    public static Logger logger = LoggerFactory.getLogger(TravelWebsiteTest.class);

    @Test
    void tourSearchTest() {
        TourSearchPage tourSearchPage = new TourSearchPage(getDriver());
        tourSearchPage
                .clickInputCountry()
                .clickCountrySelection()
                .clickInputDate()
                .clickPeriod()
                .clickPeriodSelection()
                .clickButtonSearch();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://youtravel.me/tours/"));
        logger.info("Подбор тура по параметрам");
    }

    @Test
    void openingTourTest() throws InterruptedException {
        TourSearchPage tourSearchPage = new TourSearchPage(getDriver());
        tourSearchPage.clickJourneys().clickAllJourneys();
        Assertions.assertDoesNotThrow(() -> tourSearchPage.cardSelection(2));
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://youtravel.me/tours/"));
        logger.info("Открытие страницы тура в новом окне (вкладке)");
    }

    @Test
    void filteringTourRatingTest() {
        FilteringSearchPage filteringSearchPage = new FilteringSearchPage(getDriver());
        filteringSearchPage.clickAllJourneys().clickExpertRating();
        Assertions.assertDoesNotThrow(() -> filteringSearchPage.ratingSelection(3));
        logger.info("Фильтрация поиска туров по рейтингу");
    }

    @Test
    void viewingPress() throws InterruptedException {
        AdditionalFeaturesMainPage additionalFeaturesMainPage = new AdditionalFeaturesMainPage(getDriver());
        additionalFeaturesMainPage.clickPressPortal();
        String urlPress = "https://pro.rbc.ru/news/60a67ae59a794731f96d3669";
        Assertions.assertEquals(urlPress, getDriver().getCurrentUrl());
        logger.info("Открытие страницы прессы в новом окне");
    }

    @Test
    void jobSelection() throws InterruptedException {
        AdditionalFeaturesMainPage additionalFeaturesMainPage = new AdditionalFeaturesMainPage(getDriver());
        additionalFeaturesMainPage
                .clickWorkWithUs()
                .clickOpenPositions()
                .clickPositionMarketingManager();
        String urlJob = "https://ytme.atlassian.net/wiki/spaces/TM/pages/2351923222/US+marketing+manager";
        Assertions.assertEquals(urlJob, getDriver().getCurrentUrl());
        logger.info("Подбор работы на ресурсе");
    }

    @Test
    void support() throws InterruptedException {
        AdditionalFeaturesMainPage additionalFeaturesMainPage = new AdditionalFeaturesMainPage(getDriver());
        additionalFeaturesMainPage
                .clickHelp()
                .clickSelectSupport()
                .clickRequest();
        String urlRequest = "https://youtravel.me/support/Keshbek20mir";
        Assertions.assertEquals(urlRequest, getDriver().getCurrentUrl());
        logger.info("Запрос помощи у поддержки по введеным параметрам");
    }
}
