@addtocart
Feature: Adding the products to the cart page
Scenario: The user must be able to add the products in the cart page to buy the product
Given The user is in the Product page to add the products to the cart
When The user clicks the Add to cart button for desired "<product>"
Then The System adds the product in the cart page

Examples:
|product |
|Bose    |