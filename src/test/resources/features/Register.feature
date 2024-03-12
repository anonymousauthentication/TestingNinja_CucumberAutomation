Feature: User Registration

@register
Scenario: Registration with mandetory field
Given User Navigate to Register Account Page
When user enters below details into the fields
|firstname                      |Manohar|
|lastname                       |Joshi|
|telephone                      |1234567890|
|password                       |12345|
|confirmPassowrd                |12345|
And  Selects privacy policy field
And  Clicks on continue button
Then Account should get successfully created

@register
Scenario: Register with All  field
Given User Navigate to Register Account Page
When user enters below details into the fields
|firstname                      |Manohar|
|lastname                       |Joshi|
|telephone                      |1234567890|
|password                       |12345|
|confirmPassowrd                |12345|
And  Selects Yes for newsletter
And  Selects privacy policy field
And  Clicks on continue button
Then Account should get successfully created

@register
Scenario: Register without providing any  field
Given User Navigate to Register Account Page
When User dont enter details into any field 
And Clicks on continue button
Then Error validation message should come be displayed for all the mandetory field

@register
Scenario: Register with dupicate email address
Given User Navigate to Register Account Page
When user enters below details into the fields with duplicate email
|firstname                      |Manohar|
|lastname                       |Joshi|
|email                          |manohrakantjoshi@gmail.com|
|telephone                      |1234567890|
|password                       |12345|
|confirmPassowrd                |12345|
And  Selects Yes for newsletter
And  Selects privacy policy field
And  Clicks on continue button
Then Error should display for duplicate email address