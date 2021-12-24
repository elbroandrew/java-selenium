import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class HelloWebdriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://career.habr.com/");
        //risky point here
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.class("//input[contains(@class, 'l-page-title__input')]")));

        WebElement searchInput = driver.findElement(By.class("//input[contains(@class, 'l-page-title__input')]"));
        searchInput.sendKeys("QA Java");
        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(@class, 'l-page-title__form-submit')]"));
        searchBtn.click();
        //risky point here
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'vacancy-card__title')]")));

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class, 'vacancy-card__title')]"));
        System.out.println("Results count: " + searchResults.size());

        driver.quit();
    }
}
