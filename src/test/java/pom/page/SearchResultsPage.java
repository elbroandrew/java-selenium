package pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends AbstractPAge {
    private final String splitString ="\\s";
    private WebDriver driver;
    private String searchTerm;

    private String defaultLocator = "//div[contains(@class, 'vacancy-card__title')]";

    @FindBy(xpath = "//div[contains(@class, 'vacancy-card__title')]")
    private List<WebElement> generalSearchResults;

    public SearchResultsPage(WebDriver driver, String searchTerm){
        super(driver);
        this.searchTerm = searchTerm;
    }

    public int countGeneralNumberOfSearchResults(){
        System.out.println("Search results number: " + generalSearchResults.size());
        return generalSearchResults.size();
    }

    public int countResultsNumberWithSearchTerm(){
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.xpath("//div[contains(@class, 'vacancy-card__title')]"));
        System.out.println("Search results:  " + resultsNumberWithSearchTerm.size());
        return resultsNumberWithSearchTerm.size();
    };

    private String buildLocatorForSearch(){
        String locatorForSearch = defaultLocator;
        System.out.println("DEBUG: Final locator with search terms: " + locatorForSearch);
        return locatorForSearch;
    }

    @Override
    protected AbstractPAge openPage() {
        throw new RuntimeException("think twice whether you need abstract page");
    }
}
