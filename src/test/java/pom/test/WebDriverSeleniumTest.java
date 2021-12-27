package pom.test;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.page.HomePage;
import waits.CustomConditions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class WebDriverSeleniumTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @Test(description = "First test, Jira binding can be here")
    public void commonSearchTermResultsNotEmpty() {
        int expectedSearchResultsNumber =  new HomePage()
                .openPage()
                .searchForTerms("QA Java")
                .countSearchResults();

        //page interactions are complete, final verification goes below
        Assert.assertTrue( expectedSearchResultsNumber > 0, "Search results are empty!");

    }

}
