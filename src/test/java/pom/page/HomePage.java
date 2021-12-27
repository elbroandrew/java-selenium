package pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

import java.time.Duration;

public class HomePage extends AbstractPAge {
    private static final String HOMEPAGE_URL = "https://career.habr.com/";

    @FindBy(className = "l-page-title__input")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class, 'l-page-title__form-submit')]")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    };

    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(CustomConditions.jQueryAJAXCompleted());
        return this;
    };

    public SearchResultsPage searchForTerms(String term) {
        searchInput.sendKeys(term);
        searchButton.click();
        return new SearchResultsPage(driver, term);
    }
}