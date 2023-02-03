package org.example.homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilteringSearchPage extends AbstractPage {

    @FindBy(css = "a.watch-all-tours")
    private WebElement allJourneys;

    @FindBy(css = "div.filters__item__radios")
    private WebElement expertRating;

    @FindBy(xpath = "//div[@class='filters__item__radios__item']")
    private List<WebElement> fiveTypesRating;

    public FilteringSearchPage(WebDriver driver) {
        super(driver);
    }

    public FilteringSearchPage clickAllJourneys() {
        allJourneys.click();
        return this;
    }

    public FilteringSearchPage clickExpertRating() {
        expertRating.click();
        return this;
    }

    public void ratingSelection(int n) {
        fiveTypesRating.get(n).click();
    }

}
