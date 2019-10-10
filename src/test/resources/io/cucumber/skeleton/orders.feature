Feature: Test page orders on saucedemo.com

Scenario:
the user should be able to do an order
Given user is on the login page
When user enter correct username and password
And user add producto to cars
And user start checkout
Then user finish the order