Feature: Order Placement

Scenario Outline: Purchase a dress
	Given user is on home page
	When sign in to your account
	And search for the required product "<cloth>" "<colors>" "<size>"
	Then add it to cart and place the order
	
Examples:

	|cloth	|colors		|size	|
	|cotton	|Blue,Orange|S,M	|
