Feature: Login UI

  @show
  @all
  Scenario: Not successful login
    * user is on the page "Login page"
    * user fills the field "Username field" with value "dsADA"
    * user fills the field "Password field" with value "dsADA"
    * user clicks the button "SignIn button"
    * user checks that the field "Password field" is empty




