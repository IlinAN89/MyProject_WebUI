package org.example.homework6;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdditionalFeaturesMainPage extends AbstractPage {

    @FindBy(css = "div#bx_3218110189_2975")
    private WebElement pressPortal;

    @FindBy(xpath = "//a[contains(@href,'career')]")
    private WebElement workWithUs;

    @FindBy(xpath = "//a[@href='#vacancies'][1]")
    private WebElement openPositions;

    @FindBy(xpath = "//a[contains(@href,'marketing')]")
    private WebElement positionMarketingManager;

    @FindBy(css = "div[href='/support/']")
    private WebElement help;

    @FindBy(xpath = "//a[@href='/support/'][1]")
    private WebElement selectSupport;

    @FindBy(css = "input.select2-search__field")
    private WebElement request;

    public AdditionalFeaturesMainPage(WebDriver driver) {
        super(driver);
    }

    public AdditionalFeaturesMainPage clickPressPortal() throws InterruptedException {
        pressPortal.click();
        Thread.sleep(5000);
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        return this;
    }

    public AdditionalFeaturesMainPage clickWorkWithUs() throws InterruptedException {
        workWithUs.click();
        Thread.sleep(7000);
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        return this;
    }

    public AdditionalFeaturesMainPage clickOpenPositions() {
        openPositions.click();
        return this;
    }

    public AdditionalFeaturesMainPage clickPositionMarketingManager() throws InterruptedException {
        positionMarketingManager.click();
        Thread.sleep(5000);
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        return this;
    }

    public AdditionalFeaturesMainPage clickHelp() {
        help.click();
        return this;
    }

    public AdditionalFeaturesMainPage clickSelectSupport() {
        selectSupport.click();
        return this;
    }

    public AdditionalFeaturesMainPage clickRequest(String value) throws InterruptedException {
        request.click();
        request.sendKeys(value);
        Thread.sleep(2000);
        request.sendKeys(Keys.ENTER);
        return this;
    }
}
