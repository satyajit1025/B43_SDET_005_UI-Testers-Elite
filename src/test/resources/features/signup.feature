Feature: SignUp flow check
  Scenario: Validate the signup functionality
    Given User in the homepage of the application
    When User click on create an account
    Then User redirected to the signup page and enter details
    And Click on signup button
    Then User should signup successfully

  Scenario: Validate the signup functionality with duplicate data
    Given user in the homepage of the application
    When user click on create an account
    Then user redirected to the signup page and enter duplicate details
    And click on signup button
    Then user should not able to signup