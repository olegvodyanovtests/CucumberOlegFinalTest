package pages.abstractions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    protected WebDriver webDriver;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void waitForElementToInteractWith(WebElement webElement) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, 10);
        explicitWait.until(ExpectedConditions.visibilityOf(webElement));
        explicitWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
