@run
Feature: Product search

  Scenario: All Departments Product search
    Given I am on the Home page
    And I select "<All Departments>" search
    When I search for "Coffee"
    Then I see the list of corresponding search results for product for "Coffee"