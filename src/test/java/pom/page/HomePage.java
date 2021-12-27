package pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import waits.CustomConditions;

import java.time.Duration;

public class HomePage {
        driver.get("https://career.habr.com/");

        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(CustomConditions.jQueryAJAXCompleted());

    WebElement searchInput = waitForElementLocatedBy(driver, By.className("l-page-title__input"));
        searchInput.sendKeys("QA Java");

    WebElement searchBtn = driver.findElement(By.xpath("//button[contains(@class, 'l-page-title__form-submit')]"));
        searchBtn.click();
}
