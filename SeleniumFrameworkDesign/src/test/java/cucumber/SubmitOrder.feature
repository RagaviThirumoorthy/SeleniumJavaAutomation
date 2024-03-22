@tag
Feature: Purchase the order from Ecommerce website

Background: 
Given I landed on Ecommerce page

@Regression
Scenario Outline: Positive test of submitting order

	Given login application with <username> and <password>
	When I add product <productname> to cart
	And Checkout the product <productname> and submit the order	
	Then "THANKYOU FOR THE ORDER." message is displayed
	
	Examples: 
	|username 			|password		|productname |
	|ragavi@gmail.com	|KaviKrrish*29	|ZARA COAT 3 |
