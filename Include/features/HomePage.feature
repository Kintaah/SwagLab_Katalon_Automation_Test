Feature: Web Home Page feature

  @1002
  Scenario: Verify user able to access the product details by clicking on the product image
		Given I open Swag Labs website
    When I input 'standard_user' value on the 'Username' text field
    And I input 'secret_sauce' value on the 'Password' text field
    And I click on 'Login' button
    Then User can see the home page
    When I click on 'Sauce Labs Backpack' product image
    Then User can see the 'Sauce Labs Backpack' product details
    
  @1003
  Scenario: Verify user able to click on Add to cart button
  	Given I open Swag Labs website
    When I input 'standard_user' value on the 'Username' text field
    And I input 'secret_sauce' value on the 'Password' text field
    And I click on 'Login' button
    Then User can see the home page
    When I click on 'Sauce Labs Bike Light' add to cart button
    And I click on 'Cart' button
    Then User can see the 'Sauce Labs Bike Light' in add to cart page
    
  @1004
  Scenario: Verify user able to click on Remove button after adding the product
  	Given I open Swag Labs website
    When I input 'standard_user' value on the 'Username' text field
    And I input 'secret_sauce' value on the 'Password' text field
    And I click on 'Login' button
    Then User can see the home page
    When I click on 'Sauce Labs Bike Light' add to cart button
    Then I click on 'Sauce Labs Bike Light' add to cart button
    
  @1005
  Scenario: Verify the Name sort function on home page(Ascending and descending)
  	Given I open Swag Labs website
    When I input 'standard_user' value on the 'Username' text field
    And I input 'secret_sauce' value on the 'Password' text field
    And I click on 'Login' button
    Then User can see the home page
    When I select 'Name (A to Z)' on the sort dropdown
    And Verify 'Name' sort function in 'Ascending' order
    And I select 'Name (Z to A)' on the sort dropdown
    Then Verify 'Name' sort function in 'Descending' order
    
   @1006
   Scenario: Verify the Price sort function on home page(Ascending and descending)
   	Given I open Swag Labs website
    When I input 'standard_user' value on the 'Username' text field
    And I input 'secret_sauce' value on the 'Password' text field
    And I click on 'Login' button
    Then User can see the home page
    When I select 'Price (low to high)' on the sort dropdown
    And Verify 'Price' sort function in 'Ascending' order
    And I select 'Price (high to low)' on the sort dropdown
    Then Verify 'Price' sort function in 'Descending' order