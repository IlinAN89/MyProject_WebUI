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

public class OpeningTourPage {

    private static OpeningTourPage openingTourPage;

    private OpeningTourPage() {
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
        WebElement journeys = driver.findElement(By.cssSelector("div[href='/tours/']"));
        journeys.click();
        WebElement allJourneys = driver.findElement(By.cssSelector("a[href='/tours/']"));
        allJourneys.click();
        WebElement tourCard = driver.findElement(By.xpath("//a[contains(@title,'КРАСОТЫ ДАГЕСТАНА')]"));
        tourCard.click();
        driver.quit();
    }

    public static OpeningTourPage getOpeningTourPage() {
        if (openingTourPage==null) openingTourPage = new OpeningTourPage();
        return openingTourPage;
    }
}
