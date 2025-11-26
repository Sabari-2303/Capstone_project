@login
Feature: Login page
Scenario: Login with the valid credentials
Given The user in the login page to login with valid details
When he enters the valid credentials of "<username>" and "<password>"
Then he should be able to login to the Home page

Examples:

|username   | password  |
|Sundar     |03Sundar   |