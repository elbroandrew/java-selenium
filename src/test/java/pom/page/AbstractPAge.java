package pom.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPAge {
    protected WebDriver driver;

    protected abstract AbstractPAge openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 5;

    protected AbstractPAge(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
