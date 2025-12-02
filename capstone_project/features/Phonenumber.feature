@Phonenumber
Feature: Adding phone number to the Shipping details
Scenario: The user must be able to add the Phone number in the Shipping details
Given The user is in the Payment page to add the Phone number to the Shipping details
When The user enters the invalid Phone number to Phone number section after login using "<username>" and "<password>"  and selecting the "<product>"
Then The System shows an error message as Invalid Phone number when enters the invalid "<phno>"

Examples:
|username   |password   |product  |phno     |   
|Sundar     |03Sundar   |Bose     |abcdefgh | 