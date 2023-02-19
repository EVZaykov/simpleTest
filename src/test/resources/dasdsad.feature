Feature: Login UI

  @show
  Scenario: Successful login
    * user is on the page "Login page"
    * user fills the field "Username field" with value "EVZaykov"
    * user fills the field "Password field" with value "100Rjgttr"
    * user clicks the button "SignIn button"
    * user is on the page "Main page"
    * user checks that the text "All activity" is visible
    * user clicks the button "Create new repository"


  @show
  Scenario: Not successful login
    * user is on the page "Login page"
    * user fills the field "Username field" with value "dsADA"
    * user fills the field "Password field" with value "dsADA"
    * user clicks the button "SignIn button"
    * user checks that the field "Password field" is empty

  @show
  Scenario: Fail for example
    * user is on the page "Login page"
    * user fills the field "Username field" with value "dsADA"
    * user fills the field "Password field" with value "dsADA"
    * user clicks the button "SignIn button"
    * user checks that the field "Username field" is empty



