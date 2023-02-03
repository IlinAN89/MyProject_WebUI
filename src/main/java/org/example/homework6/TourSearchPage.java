package org.example.homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TourSearchPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='multiselect__tags']")
    private WebElement inputCountry;

    @FindBy(xpath = "//span[@class='item-title' and text()='Европа']")
    private WebElement countrySelection;

    @FindBy(xpath = "//input[@name='date']")
    private WebElement inputDate;

    @FindBy(xpath = "//div[text()='Месяц или период']")
    private WebElement period;

    @FindBy(xpath = "//div[text()='90 дней']")
    private WebElement periodSelection;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;

    @FindBy(css = "div[href='/tours/']")
    private WebElement journeys;

    @FindBy(css = "a[href='/tours/']")
    private WebElement allJourneys;

    @FindBy(xpath = "//div[@class='serp-tours__result']//a")
    private List<WebElement> tourCards;

    public TourSearchPage(WebDriver driver) {
        super(driver);
    }

    public TourSearchPage clickInputCountry() {
        inputCountry.click();
        return this;
    }

    public TourSearchPage clickCountrySelection() {
        countrySelection.click();
        return this;
    }

    public TourSearchPage clickInputDate() {
        inputDate.click();
        return this;
    }

    public TourSearchPage clickPeriod() {
        period.click();
        return this;
    }

    public TourSearchPage clickPeriodSelection() {
        periodSelection.click();
        return this;
    }

    public TourSearchPage clickButtonSearch() {
        buttonSearch.click();
        return this;
    }

    public TourSearchPage clickJourneys() {
        journeys.click();
        return this;
    }

    public TourSearchPage clickAllJourneys() throws InterruptedException {
        allJourneys.click();
        Thread.sleep(5000);
        return this;
    }

    public void cardSelection(int n) throws InterruptedException {
        tourCards.get(n).click();
        Thread.sleep(5000);
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
    }

}
