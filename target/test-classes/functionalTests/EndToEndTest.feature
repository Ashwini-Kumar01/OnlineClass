Feature: end to end test for amazon

Scenario: User is able to login and buy a product

	Given user is on Amazon Home Page
	When user searches for "comb"
	And choose to buy the first item

