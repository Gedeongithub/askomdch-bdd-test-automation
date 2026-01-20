@sorting
Feature: Sort products by price
  In order to easily find products within my budget
  As a customer
  I want to sort products by price on the store page

  Background:
    Given I am on the Store page

  Scenario: Sort products by price from low to high
    When I sort products by Sort by price: low to high in ascending order
        |SortOption|Sort by price: low to high|
    Then products should be displayed in ascending order of price


  Scenario: Sort products by price from high to low
    When I sort products by Sort by price: high to low in descending order
        |SortOption|Sort by price: high to low|
    Then products should be displayed in descending order of price


  Scenario Outline: Sort products by different criteria
    When I sort products by "<sortOption>"
    Then products should be sorted by "<sortOption>"

    Examples:
      | sortOption     |
      | Sort by latest         |
      | Sort by popularity     |
      | Sort by average rating |

