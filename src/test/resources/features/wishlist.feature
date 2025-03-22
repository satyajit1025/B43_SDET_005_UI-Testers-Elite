Feature: Wishlist functionality check
  Scenario: Add product to wishlist with login
    Given User is on the homepage
    When User logged in to account
    And Add a product to the wishlist
    Then Product added successfully

  Scenario: Add product to wishlist without login
    Given user is on the homepage
    When user click on a product
    And user add to wishlist the product
    Then user not able to add to the wishlist