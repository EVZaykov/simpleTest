Feature: Login UI

  @show @all
  Scenario: long for demonstration
    * user is on the page "Login page"
    * user fills the field "Username field" with value "EVZaykov"
    * user fills the field "Password field" with value "100Rjgttr"
    * user clicks the button "SignIn button"
    * user is on the page "Main page"
    * he is waiting 100 seconds for the element to appear "Password field"
    * user checks that the text "All activity" is visible
    * user clicks the button "Create new repository"




