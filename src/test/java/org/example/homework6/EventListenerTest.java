package org.example.homework6;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;


public class EventListenerTest extends AbstractTest {

    @Test
    @DisplayName("Search for a tour by parameters")
    @Description("Country selection - Period selection by dates")
    @Link("https://youtravel.me/")
    @Issue("https://youtravel.me/tours/")
    @TmsLink("https://www.atlassian.com/ru/software/jira")
    @Severity(SeverityLevel.CRITICAL)
    void tourSearchTest() {
        try {
            TourSearchPage tourSearchPage = new TourSearchPage(getDriver());
            tourSearchPage
                    .clickInputCountry()
                    .clickCountrySelection();
            tourSearchPage
                    .clickInputDate()
                    .clickPeriod()
                    .clickPeriodSelection();
            tourSearchPage.clickButtonSearch();
            Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://youtravel.me/tours/"));
        } catch (NoSuchElementException e) {
            MyUtils.makeScreenshot(getDriver(),
                    "failure- org.example.homework6.EventListenerTest.test" + System.currentTimeMillis() + ".png");
        }
    }
}
