Feature: Checkout process
  Scenario: Checkout process check
    Given User on the homepage of the URL
    When USer add a product to the cart
    Then User checkout that product
    Then User successfully purchase that product