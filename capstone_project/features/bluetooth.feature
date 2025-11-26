@bluetooth
Feature: Filtering products by Bluetooth availability
Scenario: The user must be able to filter the products based on Bluetooth availability
Given The user is in the Speakers page to filter based on Bluetooth availability
When The user selects whether the product has "<bluetoothoption>" feature or not
Then The System displays the products contains "<bluetoothavailable>" or not

Examples:
| bluetoothoption       |  bluetoothavailable |
|wireless_technology_1  |Bluetooth            |
