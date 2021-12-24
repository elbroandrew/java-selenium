import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HelloWebdriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://hh.ru");
        WebElement searchInput = driver.findElement(By.xpath("//input[contains(@class, 'bloko-input')]"));
        searchInput.sendKeys("QA Java");
        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(@class, 'bloko-button_scale-large')]"));
        searchBtn.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
