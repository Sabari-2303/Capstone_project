@Postalcode
Feature: Adding Postal code to the Shipping details
Scenario: The user must be able to add the Postal code in the Shipping details
Given The user is in the Payment page to add the Postal code to the Shipping details
When The user enters the invalid Postal code to Postal code section after login using "<username>" and "<password>"  and selecting the "<product>" 
Then The System shows an error message as Invalid Postal code when enters the invalid "<postcode>"

Examples:
|username   |password   |product  |postcode | 
|Sundar     |03Sundar   |Bose     |abcdefgh |