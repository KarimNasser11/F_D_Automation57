Feature: Checkout Process
  As a registered user
  I want to complete a purchase
  So that I can buy a product successfully

  Background:
    Given User is logged in and on Home Page
    And User adds first product to the cart for checkout
    And User goes to the cart

  Scenario: Successful checkout
    When User proceeds to checkout
    And User fills information
    And User continues to overview
    Then Order confirmation should be displayed
