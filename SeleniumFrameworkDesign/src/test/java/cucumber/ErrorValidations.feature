
@tag
Feature: Validating the login error message
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Negative Testing of Login
    Given I landed on Ecommerce page
    When login application with <username> and <password>
    Then Error "Incorrect email or password." is displayed

    Examples: 
      |username 				|password				|
			|ragavi@gmail.com	|KaviKrrish			|
