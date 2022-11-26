Feature: Send an email to recipient

# Scenario 1 End to end test of sending email
#  Тест умеет следующее:
#  1. залогиниться на mail.ru;
#  2. написать письмо любого содержания c заполнением поля Body (текста самого письма);
#  3. отправить письмо.
#  4. проверить наличие сообщения об отправке письма.
  @test_assignment
  Scenario: Check that the user can get send email
    Given User opens the page https://www.mail.ru
    When User clicks the login button
    Then User sees a pop up window
    And User enters his user name user name
    And User presses next button
    And User enters his password password
    And User presses submit button
    And User presses compose button on main page
    And User puts email address recipient's address into recipient field
    And User puts the following Subject subject text
    And User puts the following Text body text and presses send button
    When User goes to sent emails page
    Then User sees his last sent email with the following Subject subject text Recipient email address and Body body text
