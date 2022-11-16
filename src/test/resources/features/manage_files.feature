Feature: User should be able to add a folder and  upload a file directly
  Story: User should be able to manage folders.

  @US7-TC1
  Scenario Outline: Verify user can add a folder
    Given User is on the login page
    When User enters username "<username>" and password "<password>"
    And User clicks the login button
    And  User is at the dashboard page
    When the user clicks the Files module
    And user clicks the add icon on the top
    And user clicks the new folder
    And user write a folder "name"
    When the user click submit icon
    Then Verify the folder "name" is displayed on the page
    Examples:
      | username | password    |
      | User20   | Userpass123 |
      | User50   | Userpass123 |
      | User20   | Userpass123 |
      | User110  | Userpass123 |

  @US7-TC2
  Scenario Outline: Verify user  can upload a file inside a folder
    Given User is on the login page
    When User enters username "<username>" and password "<password>"
    And User clicks the login button
    And  User is at the dashboard page
    When the user clicks the Files module
    And user choose a folder from the page
    And user clicks the add icon on the top
    When the user uploads a file with the upload file option
    Then Verify the file is displayed on the page
    Examples:
      | username | password    |
      | User20   | Userpass123 |
      | User50   | Userpass123 |
      | User80   | Userpass123 |
      | User110  | Userpass123 |