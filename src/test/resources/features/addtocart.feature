Feature: Add To Cart
  Scenario: Add a product to the cart
    Given User on the Homepage
    When User login to the account
    And User add a product to the cart
    Then Product added to the cart successfully
