Feature: Search for products
  Scenario: Search a pant
    Given User on the homepage
    When User login to account
    Then User click on search and search a product
    Then User get data as per search