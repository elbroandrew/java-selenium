package pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {


        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'vacancy-card__title')]")));

    List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class, 'vacancy-card__title')]"));
        System.out.println("Results count: " + searchResults.size());

}
