package pom.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.page.HomePage;

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
