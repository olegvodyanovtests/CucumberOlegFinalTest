package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.abstractions.AbstractPage;

//Класс создаy для управления логином пользователя на самом начальном этапе, перед отправкой сообщения
public class LoginPage extends AbstractPage {
    protected WebDriver webDriver;

    @FindBy(css = "button[data-testid=\"enter-mail-primary\"]")
    private WebElement loginButton;

    @FindBy(name = "username")
    private WebElement userNameField;
    @FindBy(name = "password")
    private WebElement userPasswordField;

    @FindBy(className = "ag-popup__frame__layout__iframe")
    private WebElement popUpWindow;

    @FindBy(css = "button[data-test-id=\"next-button\"]")
    private WebElement nextButton;
    @FindBy(css = "button[data-test-id=\"submit-button\"]")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //После того, как мы нажали кнопку входа появляется iframe элемент
    public void getLoginPopUpMenu() {
        waitForElementToInteractWith(loginButton);
        loginButton.click();
    }

    public boolean popUpWindowIsHere() {
        waitForElementToInteractWith(popUpWindow);
        return popUpWindow.isDisplayed();
    }

    public void enterUserNameInPopUpMenu(String userName) {
        waitForElementToInteractWith(popUpWindow);
        selectIframe(popUpWindow);
        userNameField.sendKeys(userName);
    }

    public void enterPasswordInPopUpMenu(String password) {
        waitForElementToInteractWith(userPasswordField);
        userPasswordField.sendKeys(password);
    }

    public void pressNextButton() {
        waitForElementToInteractWith(nextButton);
        nextButton.click();
    }
    public MainPage pressSubmitButtonToLoginIntoMainPage() {
        waitForElementToInteractWith(submitButton);
        submitButton.click();
        return new MainPage(webDriver);
    }

    private void selectIframe(WebElement iframe) {
        webDriver.switchTo().frame(iframe);
    }


}
