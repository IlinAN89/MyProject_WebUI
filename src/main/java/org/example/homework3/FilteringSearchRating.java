package org.example.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilteringSearchRating {

    private static FilteringSearchRating filteringSearchRating;

    private FilteringSearchRating() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://youtravel.me/");

        WebElement closeCookie = (new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='cookie-notification__button']"))));
        closeCookie.click();
        WebElement allJourneys = driver.findElement(By.cssSelector("a.watch-all-tours"));
        allJourneys.click();
        WebElement rating = driver.findElement(By.cssSelector("div.filters__item__radios"));
        rating.click();
        WebElement ratingSelection = driver.findElement(By.xpath("//div[@class='filters__item__radios__item'][2]"));
        ratingSelection.click();
        driver.quit();
    }

    public static FilteringSearchRating getFilteringSearchRating() {
        if(filteringSearchRating==null) filteringSearchRating = new FilteringSearchRating();
        return filteringSearchRating;
    }
}
