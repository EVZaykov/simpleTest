Feature: Login User


  Scenario Outline: Login user
    * User navigates to GitHub website
    * User enters a "<username>" username
    * User enters a "<password>" password
    * User click on the Sign in button
    * I should be take to the fault message
    Examples:
      | username  | password  |
      |           | test      |
      | test      |           |
      | qwerty123 | qwerty123 |
  @qwert
  Scenario: Positive Login
    * User navigates to GitHub website
    * User enters a "EVZaykov" username
    * User enters a "Test1VTB" password
    * User click on the Sign in button
    * User should be take to the successful login




