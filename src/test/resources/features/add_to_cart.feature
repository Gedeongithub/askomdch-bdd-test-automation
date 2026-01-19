@cart
Feature: Add products to shopping cart

  In order to purchase products
  As a customer
  I want to add one or more products to my shopping cart

  Scenario: Add a product to the cart by name
   Given I am on the Store page
   When I add the following products to the cart
      | Anchor Bracelet                 |
      | Basic Blue Jeans                |
      | Black Over-the-shoulder Handbag |
    And open Cart page
    Then products should be added to the cart
      | Anchor Bracelet                 |
      | Basic Blue Jeans                |
      | Black Over-the-shoulder Handbag |



