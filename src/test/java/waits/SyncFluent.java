package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class SyncFluent {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://career.habr.com/");
        //risky point here
//        new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(CustomConditions.jQueryAJAXCompleted());

        WebElement searchInput = waitForElementLocatedBy(driver, By.className("l-page-title__input"));
        searchInput.sendKeys("QA Java");
        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(@class, 'l-page-title__form-submit')]"));
        searchBtn.click();
        //risky point here

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout for waiting search result list was exceeded");

        List<WebElement> searchResults = wait.until(new Function<WebDriver, List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver webDriver) {
                return driver.findElements(By.xpath("//div[contains(@class, 'vacancy-card__title')]"));
            }
        });

        System.out.println("Results count: " + searchResults.size());

        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
