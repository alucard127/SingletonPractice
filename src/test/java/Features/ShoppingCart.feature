Feature: Shopping Cart

  Scenario: Buy a Cart

    Given user shopping cart contains
    When User Click checkout
    Then User Choose a shipping option

  Scenario: Payment Method

    Given user click pay by check
    When User Confirm My Order
    Then The system Check must Include




