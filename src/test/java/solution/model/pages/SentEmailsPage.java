package solution.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Класс управляет страницей с отправленными письмами, в частности ищет последнее отправленное письмо
public class SentEmailsPage {
    private WebDriver webDriver;
    @FindBy(css = "a[title=\"Отправленные\"]")
    private WebElement sentEmailsPageButton;
    @FindBy(className = "llc_first")
    private WebElement lastSentEmailContainer;

    public SentEmailsPage getSentEmailsPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
        return new SentEmailsPage();
    }

    public void goesToSentEmailsPage() {
        waitForElementToInteractWith(sentEmailsPageButton);
        sentEmailsPageButton.click();
    }

    public String lastSentEmailContainsRecipient() {
        waitForElementToInteractWith(lastSentEmailContainer);
        return getAttributeOfSentEmail("llc__item_correspondent");
    }

    public String lastSentEmailContainsSubject() {
        waitForElementToInteractWith(lastSentEmailContainer);
        return getAttributeOfSentEmail("llc__subject");
    }

    public String lastSentEmailContainsBody() {
        waitForElementToInteractWith(lastSentEmailContainer);
        return getAttributeOfSentEmail("llc__snippet");
    }

    private String getAttributeOfSentEmail(String attribute) {
        return lastSentEmailContainer.findElement(By.className(attribute)).getText();
    }

    private void waitForElementToInteractWith(WebElement webElement) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, 10);
        explicitWait.until(ExpectedConditions.visibilityOf(webElement));
        explicitWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
