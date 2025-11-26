@Invalidlogin
Feature: Invalid login page
Scenario: Login with the Invalid credentials
Given The user in the login page to login with Invalid details
When he enters the Invalid credentials of "<username>" and "<password>"
Then he should not be able to login to the Home page

Examples:

|username   |password   |
|abcd       |04Maran    |