Feature: Search product functionality

Scenario: Search for valid product name
Given open Application url
When User enters valid product name "HP"
And Click on search button
Then Valid product should get displayed in search result 

Scenario: Search for non-existing product
Given open Application url
When User enters the non-existing product in search box "Honda"
And Click on search button 
Then Proper text information the user about no  product matching should be displayed.

Scenario: Search for invalid product name
Given open Application url
When User dont enter any product in search box
And Click on search button
Then Proper text information the user about no  product matching should be displayed.