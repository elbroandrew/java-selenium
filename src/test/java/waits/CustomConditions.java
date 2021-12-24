package waits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
    public static ExpectedCondition<Boolean> jQueryAJAXCompleted() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                try {
                    if (!((Boolean) ((JavascriptExecutor) webDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);"))) {
                        System.out.println("JQUERY.ACTIVE IS WORKING AT THE MOMENT! jQuery.active= " + ((JavascriptExecutor) webDriver).executeScript("return jQuery.active"));
                    }
                    return (Boolean) ((JavascriptExecutor) webDriver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
    }
}
