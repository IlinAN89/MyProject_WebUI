package org.example.homework5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TravelWebsiteTest extends AbstractTest {

    public static Logger logger = LoggerFactory.getLogger(TravelWebsiteTest.class);

    @Test
    void openingTourPage() throws InterruptedException {
        WebElement journeys = getDriver().findElement(By.cssSelector("div[href='/tours/']"));
        journeys.click();
        WebElement allJourneys = getDriver().findElement(By.cssSelector("a[href='/tours/']"));
        allJourneys.click();
        WebElement tourCard = getDriver().findElement(By.xpath("//a[contains(@title,'КРАСОТЫ ДАГЕСТАНА')]"));
        tourCard.click();
        Thread.sleep(5000);
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        String urlCard = "https://youtravel.me/tours/17952/_%D0%BA%D1%80%D0%B0%D1%81%D0%BE%D1%82%D1%8B_%D0%B4%D0%B0%D0%B3%D0%B5%D1%81%D1%82%D0%B0%D0%BD%D0%B0_%D0%B7%D0%B0_5_%D0%B4%D0%BD%D0%B5%D0%B9_-_%D0%B2%D1%81%D1%91_%D0%B2%D0%BA%D0%BB%D1%8E%D1%87%D0%B5%D0%BD%D0%BE_?date_id=303570&participants=1";
        Assertions.assertEquals(urlCard, getDriver().getCurrentUrl());
        logger.info("Открытие страницы тура в новом окне");
    }

    @Test
    void filteringSearchRating() {
        WebElement allJourneys = getDriver().findElement(By.cssSelector("a.watch-all-tours"));
        allJourneys.click();
        WebElement rating = getDriver().findElement(By.cssSelector("div.filters__item__radios"));
        rating.click();
        WebElement ratingSelection = getDriver().findElement(By.xpath("//div[@class='filters__item__radios__item'][2]"));
        ratingSelection.click();
        logger.info("Фильтрация поиска туров по рейтингу");
    }

    @Test
    void tourSearch() {
        WebElement inputCountry = getDriver().findElement(By.xpath("//div[@class='multiselect__tags']"));
        inputCountry.click();
        WebElement countrySelection = getDriver().findElement(By.xpath("//span[@class='item-title' and text()='Европа']"));
        countrySelection.click();
        WebElement inputDate = getDriver().findElement(By.xpath("//input[@name='date']"));
        inputDate.click();
        WebElement period = getDriver().findElement(By.xpath("//div[text()='Месяц или период']"));
        period.click();
        WebElement periodSelection = getDriver().findElement(By.xpath("//div[text()='90 дней']"));
        periodSelection.click();
        WebElement buttonSearch = getDriver().findElement(By.xpath("//button[@type='submit']"));
        buttonSearch.click();
        logger.info("Подбор тура по параметрам");
    }

    @Test
    void viewingPress() throws InterruptedException {
        WebElement pressSelection = getDriver().findElement(By.cssSelector("div#bx_3218110189_2975"));
        pressSelection.click();
        Thread.sleep(5000);
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        String urlPress = "https://pro.rbc.ru/news/60a67ae59a794731f96d3669";
        Assertions.assertEquals(urlPress, getDriver().getCurrentUrl());
        logger.info("Открытие страницы прессы в новом окне");
    }

    @Test
    void jobSelection() throws InterruptedException {
        WebElement workWithUs = getDriver().findElement(By.xpath("//a[contains(@href,'career')]"));
        workWithUs.click();
        Thread.sleep(7000);
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        WebElement openPositions = getDriver().findElement(By.xpath("//a[@href='#vacancies'][1]"));
        openPositions.click();
        WebElement positionMarketingManager = getDriver().findElement(By.xpath("//a[contains(@href,'marketing')]"));
        positionMarketingManager.click();
        Thread.sleep(5000);
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        String urlPress = "https://ytme.atlassian.net/wiki/spaces/TM/pages/2351923222/US+marketing+manager";
        Assertions.assertEquals(urlPress, getDriver().getCurrentUrl());
        logger.info("Подбор работы на ресурсе");
    }

    @Test
    void support() throws InterruptedException {
        WebElement help = getDriver().findElement(By.cssSelector("div[href='/support/']"));
        help.click();
        WebElement selectSupport = getDriver().findElement(By.xpath("//a[@href='/support/'][1]"));
        selectSupport.click();
        WebElement request = getDriver().findElement(By.cssSelector("input.select2-search__field"));
        request.click();
        logger.info("Запрос помощи у поддержки по введеным параметрам");
    }
}
