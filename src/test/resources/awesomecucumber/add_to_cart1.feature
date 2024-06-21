Feature: Add to cart

  Scenario: Add one quantity from store
    Given I'm on the store page1
    When I add a "Blue Shoes" to the cart1
    Then I should see "1" "Blue Shoes" in the cart1

#  Scenario Outline: Add one quantity from store
#    Given I'm on the store page1
#    When I add a "<product_name>" to the cart1
#    Then I should see "1" "<product_name>" in the cart1
#    Examples:
#      | product_name |
#      |Anchor Bracelet|
#      |Basic Blue Jeans|