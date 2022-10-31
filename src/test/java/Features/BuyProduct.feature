Feature: Make a purchase

  Scenario: How to Buy Product

    Given user You have to login
    When User filis with valid fields
    Then the system Make the payment method

  Scenario: Buy a T-shirts

    Given User clicks on T-shirts
    When User will choose the image of the garment
    And Add Cart
    Then User Click checkout




