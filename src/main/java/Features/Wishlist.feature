#@run
Feature: Wish lists

  In order to
  As a store owner
  I want

  Scenario: Web site visitor creates a wish list
    Given I am a web site visitor
    And I want to create a wish list
    When I enter a wish list name "My Birthday Wish List"
    And I select a theme "Birthday"
    And select create a wish list
    Then a new wish list "My Birthday Wish List" is created