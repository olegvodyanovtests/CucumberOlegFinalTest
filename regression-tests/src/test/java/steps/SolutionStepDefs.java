package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import pages.LoginPage;
import pages.MainPage;
import pages.SentEmailsPage;

import static hooks.SolutionHooks.webDriver;
@CucumberContextConfiguration
public class SolutionStepDefs {
    private LoginPage loginPageObject;
    private MainPage mainPage;
    private SentEmailsPage sentEmailsPage;

    @Given("User opens the page {}")
    public void userHasBrowser(String url) {
        webDriver.navigate().to(url);
    }

    @When("User clicks the login button")
    public void userClicksLoginButton() {
        loginPageObject = new LoginPage(webDriver);
        loginPageObject.getLoginPopUpMenu();
    }

    @Then("User sees a pop up window")
    public void userObservesPopUpWindowOnLoginPage() {
        Assert.assertTrue(loginPageObject.popUpWindowIsHere());
    }

    @Then("User enters his user name {}")
    public void userEntersHisUserNameInPopUpWindowOnLoginPage(String userName) {
        loginPageObject.enterUserNameInPopUpMenu(userName);
    }

    @Then("User presses next button")
    public void userPressesNextButtonInPopUpWindowOnLoginPage() {
        loginPageObject.pressNextButton();
    }

    @Then("User enters his password {}")
    public void userEntersHisPasswordInPopUpWindowOnLoginPage(String password) {
        loginPageObject.enterPasswordInPopUpMenu(password);
    }

    @Then("User presses submit button")
    public void userPressesSubmitButtonInPopUpWindowOnLoginPage() {
        mainPage = loginPageObject.pressSubmitButtonToLoginIntoMainPage();
    }

    @Then("User presses compose button on main page")
    public void userPressesComposeButtonOnMainPage() {
        mainPage.pressComposeButton();
    }

    @Then("User puts {} recipient's address into recipient field")
    public void userPutsRecipientAddressIntoRecipientFieldOnMainPage(String recipientAddress) {
        mainPage.putRecipientIntoField(recipientAddress);
    }

    @Then("User puts the following Subject {}")
    public void userPutsSubjectIntoSubjectFieldOnMainPage(String subject) {
        mainPage.putSubjectIntoField(subject);
    }

    @Then("User puts the following Text {} and presses send button")
    public void userPutsTextIntoTextAreaOnMainPage(String text) {
        mainPage.putTextIntoArea(text);
        sentEmailsPage = mainPage.pressSendButton();
    }

    @Then("User goes to sent emails page")
    public void userGoesToSentEmailsPage() {
        sentEmailsPage.goesToSentEmailsPage();
    }

    @Then("User sees his last sent email with the following Subject {} Recipient {} and Body {}")
    public void userSeesHisLastSentEmailOnEmailsPage(String subjectToCompare, String recipientToCompare,
                                                     String bodyToCompare) {
        String subject = sentEmailsPage.lastSentEmailContainsSubject();
        String recipient = sentEmailsPage.lastSentEmailContainsRecipient();
        String body = sentEmailsPage.lastSentEmailContainsBody();
        System.out.println(subject + " " + recipient + " " + " " + body);
        Assert.assertTrue(subject.contains(subjectToCompare));
        Assert.assertTrue(recipient.contains(recipientToCompare));
        Assert.assertTrue(body.contains(bodyToCompare));
    }
}
