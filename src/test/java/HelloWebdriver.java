import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWebdriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://hh.ru");
        WebElement searchInput = driver.findElement(By.xpath("//input[contains(@class, 'bloko-input')]"));
        searchInput.sendKeys("QA Java");
        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(@class, 'bloko-button_scale-large')]"));
        searchBtn.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
