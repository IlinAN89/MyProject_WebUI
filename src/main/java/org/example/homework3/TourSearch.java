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

public class TourSearch {

    private static TourSearch tourSearch;

    private TourSearch() {
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
        WebElement inputCountry = driver.findElement(By.xpath("//div[@class='multiselect__tags']"));
        inputCountry.click();
        WebElement countrySelection = driver.findElement(By.xpath("//span[@class='item-title' and text()='Европа']"));
        countrySelection.click();
        WebElement inputDate = driver.findElement(By.xpath("//input[@name='date']"));
        inputDate.click();
        WebElement period = driver.findElement(By.xpath("//div[text()='Месяц или период']"));
        period.click();
        WebElement periodSelection = driver.findElement(By.xpath("//div[text()='90 дней']"));
        periodSelection.click();
        WebElement buttonSearch = driver.findElement(By.xpath("//button[@type='submit']"));
        buttonSearch.click();
        driver.quit();
    }

    public static TourSearch getTourSearch() {
        if (tourSearch==null) tourSearch = new TourSearch();
        return tourSearch;
    }
}
