@quantity
Feature: Adding the number of products needed in quantity section
Scenario: The user must be able to add the number of products in the quantity section
Given The user is in the Product page to enter the quantity of product
When The user enters the desired "<product>" quantity
Then The System adds the desired product "<quantity>" in the cart page


Examples:

|product    |quantity   |
|HP         |10         |