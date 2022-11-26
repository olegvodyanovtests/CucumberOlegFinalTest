package solution.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//Класс управляет главной страницей котторая открывается пользователю после успешного входа в личный аккаунт
public class MainPage {
    private WebDriver webDriver;
    @FindBy(className = "compose-button")
    private WebElement composeButton;
    @FindBy(className = "ph-project-promo-close-icon")
    private WebElement promoElement;
    @FindBy(css = "div[data-type=\"to\"]")
    private WebElement recipientContainer;
    @FindBy(name = "Subject")
    private WebElement subjectField;
    @FindBy(css = "div[role=\"textbox\"]")
    private WebElement textBoxArea;
    @FindBy(css = "button[data-test-id=\"send\"]")
    private WebElement sendButton;

    public MainPage getMainPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
        return new MainPage();
    }

    public void pressComposeButton() {
        promoElementsClose();
        waitForElementToInteractWith(composeButton);
        composeButton.click();
    }
    public void putRecipientIntoField(String recipient) {
        waitForElementToInteractWith(recipientContainer);
        recipientContainer.findElement(By.tagName("input")).sendKeys(recipient);
    }
    public void putSubjectIntoField(String subject) {
        waitForElementToInteractWith(subjectField);
        subjectField.sendKeys(subject);
    }
    public void putTextIntoArea(String text) {
        waitForElementToInteractWith(textBoxArea);
        textBoxArea.sendKeys(text);
    }
    public void pressSendButton() {
        waitForElementToInteractWith(sendButton);
        sendButton.click();
    }
    private void promoElementsClose(){
        waitForElementToInteractWith(promoElement);
        promoElement.click();
    }
    private void waitForElementToInteractWith(WebElement webElement) {
        WebDriverWait explicitWait = new WebDriverWait(webDriver, 10);
        explicitWait.until(ExpectedConditions.visibilityOf(webElement));
        explicitWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
