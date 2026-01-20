@account
Feature: User Registration

  As an Askmodch new user,
  I want to create an account by registering
  so that I can log on system whenever I want

  Background:
    Given New user is on the Account Page

  Rule: New user is registered as provided data are valid

    Scenario: Register with valid data
     When New user register with valid data
      |username     |tester18          |
      |email address|tester18@gmail.com|
      |password     |tesTer12345@askomdch|
     And click Register button
     Then New user is registered and get welcome message with name "tester18"

  Rule: New use is not registered as provided data are invalid
    Scenario Outline: Register with invalid data
      When New user register with invalid "<username>","<email>" and "<password>"
      And click Register button
      Then Warning message is displayed
  Examples:
      |username|email            |password             |
      |tester2 |                 |tesTer12345@askomdch |
      |tester3 |tester3@gmail.com|                     |
      |        |tester4@gmail.com|tesTer12345@askomdch |
      |        |                 |                     |
      |        |tester4@gmail.com|                     |