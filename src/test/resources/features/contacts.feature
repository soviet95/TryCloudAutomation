Feature: As a user, I should be able to access to Contacts module

  User Story: As a user, I should be able to access to Contacts module.

@wip
  Scenario: verify user access to Contacts module
    Given user on the dashboard page
    When the user clicks the "Contacts" module
    Then verify the page title is "Contacts - Trycloud QA"
