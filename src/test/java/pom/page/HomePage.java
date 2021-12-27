package pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

import java.time.Duration;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://career.habr.com/";
    private WebDriver driver;

    @FindBy(className = "l-page-title__input")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class, 'l-page-title__form-submit')]")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    };
    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(CustomConditions.jQueryAJAXCompleted());
        return this;
    };

    public SearchResultsPage searchForTerms(String term){
        searchInput.sendKeys("QA Java");
        searchButton.click();
        return new SearchResultsPage(driver, term);
    }

//
//    WebElement searchInput = waitForElementLocatedBy(driver, By.className("l-page-title__input"));
//        searchInput.sendKeys("QA Java");
//
//    WebElement searchBtn = driver.findElement(By.xpath("//button[contains(@class, 'l-page-title__form-submit')]"));
//        searchBtn.click();
}
