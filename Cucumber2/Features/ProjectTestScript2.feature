Feature: Enter invalid credantial and get Error message

Scenario: Epic sadface: Sorry, this user has been locked out
Given enter invalid user name and password
When enter user name and password
Then user should see the error message