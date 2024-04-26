Feature: Web Login Page

  @1000
  Scenario: Verify user can login successfully
    Given I open Swag Labs website
    When I input 'standard_user' value on the 'Username' text field
    And I input 'secret_sauce' value on the 'Password' text field
    And I click on 'Login' button
    Then User can see the home page

  @1001
  Scenario: Verify the system will display error when login with invalid value
    Given I open Swag Labs website
    When I input 'standard_user' value on the 'Username' text field
    And I input 'secret_sauce123' value on the 'Password' text field
    And I click on 'Login' button
    Then User can see the 'Epic sadface: Username and password do not match any user in this service' error message
