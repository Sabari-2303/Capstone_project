@manufacturer
Feature: Filtering products by the manufacturer
Scenario: The user must be able to filter products based on Manufacturer
Given The user is in the Speakers page to filter based on Manufacturer
When The user selects the "<Manufacturerid>" from the available list
Then The System displays the products of the "<Manufacturername>"

Examples:
|Manufacturerid   |Manufacturername  |
|manufacturer_1   |HP                |