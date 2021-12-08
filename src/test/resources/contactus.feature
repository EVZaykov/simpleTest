Feature: Login User
@test
	Scenario: Positive Login
		Given I navigate to github.com
		And I enter a "EVZaykov" Username
		And I enter a "Test1VTB" Password
		When I click on the Sign in button
		Then I should be take to the successful login

	Scenario Outline: Negative login
		Given I navigate to github.com
		And I enter a "<username>" Username
		And I enter a "<password>" Password
		When I click on the Sign in button
		Then I should be take to the fault message

		Examples:
		|username |password |
		|         |test     |
		|test     |         |
		|qwerty123|qwerty123|