Feature: Add to cart

  Scenario: Add one quantity from store
    Given I'm on the store page1
    When I add a "Blue Shoes" to the cart1
    Then I should see "1" "Blue Shoes" in the cart1