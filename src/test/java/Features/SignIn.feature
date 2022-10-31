Feature: Login

  Scenario:  User user login in to the website
    Given User enter the login
    When User fills in the <Email address> and <Password> fields
    Then The system will redirect to My Account

    Given User as on Login in Screen
    When User filis with valid fields
    Then The system will redirect to My Account


