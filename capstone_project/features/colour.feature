@colour
Feature: Filtering products by the colour of the product
Scenario: The user must be able to filter the products based on the colour
Given The user is in the Speakers page to filter based on colour
When The user selects the desired "<colour>" of the product
Then The System displays the  desired "<manufacturer>" products in the desired "<colour>"

Examples:
|manufacturer   | colour  |
|Logitech       |BLACK    |
