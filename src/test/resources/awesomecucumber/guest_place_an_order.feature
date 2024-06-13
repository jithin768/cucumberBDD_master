Feature:

  Scenario:Using default payment option
    Given I'm a guest customer
    And I have a product in the cart
    And I'm on the Checkout page
    When I provide billing details
    | firstname | lastname | country           | address_line1     | city  | state | zip   | email              |
    | demo      | user     |United States (US) | 6300 Spring Creek | Plano | Texas | 75025 | jithinma@gmail.com |
    And I place an order
    Then the order should be placed successfully