Feature: User should be able to login using valid credentials.

  Background:
    Given User is on the login page


  Scenario Outline: Verify login with valid credentials

    When User enters username "<username>" and password "<password>"

    And User clicks the login button
    Then User is at the dashboard page
    Examples:
      | username | password    |
      | User20   | Userpass123 |
      | User50   | Userpass123 |
      | User20   | Userpass123 |
      | User110  | Userpass123 |


  Scenario Outline: Verify user login fail with invalid credentials
    When User enters invalid username "<username>" and password "<password>"

    And User clicks the login button
    Then User should see the "<message>" message
    Examples:
      | username | password | message                     |
      | User9    | invalid  | Wrong username or password. |
      | User20   | test     | Wrong username or password. |
      | Wrong    | Wrong    | Wrong username or password. |
