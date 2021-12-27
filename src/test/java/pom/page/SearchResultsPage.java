package pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {
    private final String splitString ="\\s";
    private WebDriver driver;
    private String searchTerm;

    private String defaultLocator = "//div[contains(@class, 'vacancy-card__title')]";

    @FindBy(xpath = "//div[contains(@class, 'vacancy-card__title')]")
    private List<WebElement> generalSearchResults;

    public SearchResultsPage(WebDriver driver, String searchTerm){
        this.searchTerm = searchTerm;
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public int countGeneralNumberOfSearchResults(){
        System.out.println("Search results number: " + generalSearchResults.size());
        return generalSearchResults.size();
    }

    public int countResultsNumberWithSearchTerm(){
        List<WebElement> resultsNumberWithSearchTerm = driver.findElements(By.xpath("//div[contains(@class, 'vacancy-card__title')]"));
        System.out.println("Search results:  " + resultsNumberWithSearchTerm.size());
    }

//        new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'vacancy-card__title')]")));

//    List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class, 'vacancy-card__title')]"));
//        System.out.println("Results count: " + searchResults.size());


    private String buildLocatorForSearch(){
        String locatorForSearch = defaultLocator;
        System.out.println("DEBUG: Final locator with search terms: " + locatorForSearch);
        return locatorForSearch;
    }
}
