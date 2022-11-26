package solution.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import solution.model.pages.*;


import static solution.steps.SolutionHooks.webDriver;

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
        loginPageObject = new LoginPage();
        loginPageObject.getLoginPage(webDriver);
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
        loginPageObject.pressSubmitButton();
    }

    @Then("User presses compose button on main page")
    public void userPressesComposeButtonOnMainPage() {
        mainPage = new MainPage();
        mainPage.getMainPage(webDriver);
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
        mainPage.pressSendButton();
    }

    @Then("User goes to sent emails page")
    public void userGoesToSentEmailsPage() {
        sentEmailsPage = new SentEmailsPage();
        sentEmailsPage.getSentEmailsPage(webDriver);
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
