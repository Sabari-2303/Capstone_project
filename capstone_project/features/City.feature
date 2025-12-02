@City
Feature: Adding City to the Shipping details
Scenario: The user must be able to add the City in the Shipping details
Given The user is in the Payment page to add the City to the Shipping details
When The user enters the invalid City to City section after login using "<username>" and "<password>"  and selecting the "<product>" 
Then The System shows an error message as Invalid City when enters the invalid "<city>"

Examples:
|username   |password   |product  |city      | 
|Sundar     |03Sundar   |Bose     |12345678  |