@account
Feature: User login

  As an askmodch registered user
  I want to log in to the application
  So that I can access my account when credentials are valid
  and be prevented from logging in when credentials are invalid


Background:
  Given I am on the Account Page

Rule: Access is granted to users with valid credentials
  Scenario: Login with valid credentials
    When I log in with valid credentials
          |username|tester|
          |password|tester|
    Then I should be redirected to the Dashboard
    And I should see a welcome message with "tester"


Rule: Access is denied for users with invalid credentials
  Scenario Outline: Login with invalid credentials
    When I log in with username "<username>" and password "<password>"
    Then I should see a login error message

    Examples:
      | username              | password      |
      | wronguser@test.com    | correct123    |
      | correct@test.com      | wrongpass     |
      |                       |               |
      |                       | correct123    |
      | correct@test.com      |               |
