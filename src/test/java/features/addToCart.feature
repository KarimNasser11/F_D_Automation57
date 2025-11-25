Feature: Add product to cart
Scenario: Add first product to cart
Given User is on Home Page
When User adds first product to the cart
And User opens the cart
Then The first product should appear in the cart
