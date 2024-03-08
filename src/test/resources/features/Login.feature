Feature: Login Functionality

Scenario: Login with valid credential
Given User have navigate to login page
When User has enter valid email address "manoharkantjoshi@gmail.com"
And User has enter valid passsword "Admin@123"
And User click on login button
Then User should get successfully login

Scenario: Login with invalid credential
Given  User have navigate to login page
When User have enter invalid email "manoharkantjoshi11@gmail.com"
And User have enter invalid password "abcdef"
And User click on login button
Then User should get a warning message

Scenario: Login with valid email and invalid password
Given User have navigate to login page
When User has enter valid email address "manoharkantjoshi@gmail.com"
And User has enter invalid passsword "abcdef"
And User click on login button
Then User should get a warning message

Scenario: Login with invalid email and valid password
Given User have navigate to login page
When User has enter valid email address "manoharkantjoshi11@gmail.com"
And User has enter invalid passsword "123456"
And User click on login button
Then User should get a warning message

Scenario: Login without providing any credential
Given User have navigate to login page
When User dont enter any thing in input field
And User click on login button 
Then User should get a warning message