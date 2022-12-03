package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.abstractions.AbstractPage;

//Класс управляет страницей с отправленными письмами, в частности ищет последнее отправленное письмо
public class SentEmailsPage extends AbstractPage {
    protected WebDriver webDriver;
    @FindBy(css = "a[title=\"Отправленные\"]")
    private WebElement sentEmailsPageButton;
    @FindBy(className = "llc_first")
    private WebElement lastSentEmailContainer;
    public SentEmailsPage (WebDriver driver) {
        super(driver);
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
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

}
