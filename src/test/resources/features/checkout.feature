Feature: Checkout products

  In order to complete my purchase
  As a customer
  I want to checkout products from the store successfully

  Scenario: Successfully checkout multiple products

    Given I am on the Store page

    When I add the following products to the cart
      | Anchor Bracelet                 |
      | Basic Blue Jeans                |
      | Black Over-the-shoulder Handbag |

    And I proceed to the Checkout page

    When I fill in the checkout form with valid details
    |FirstName     |LastName          |StreetAddress|City|ZIPCode|Phone|Email|
    |John          |Doe               |123 Main Street|Kigali|02500|0791110134|Jogh@test.com|

    And I place the order

    Then the order should be placed successfully
    And I should see an order confirmation message