Feature: Login and Add product to cart

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid username and password
    And clicks on login button
    Then the user should be logged in successfully

  Scenario: Add first product to cart
    Given User is on Home Page
    When User adds first product to the cart
    And User opens the cart
    Then The first product should appear in the cart
