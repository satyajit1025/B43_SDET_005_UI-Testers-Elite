Feature: Login flow check
  Scenario: Login with valid credentials
    Given User on the homepage of url
    When User click on SignIn
    Then User redirected to the Login page and enter details
    And Click on Login
    Then User should login successfully

  Scenario: Login with invalid data
    Given user on the homepage of the url
    When user click on on signIn
    Then user redirected to login page and enter details
    And click on login
    Then user shouldnot login