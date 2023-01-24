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

public class ViewingPress {

    private static ViewingPress viewingPress;

    private ViewingPress() {
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
        WebElement pressSelection = driver.findElement(By.cssSelector("div#bx_3218110189_2975"));
        pressSelection.click();
        driver.quit();
    }

    public static ViewingPress getViewingPress() {
        if (viewingPress==null) viewingPress = new ViewingPress();
        return viewingPress;
    }
}
