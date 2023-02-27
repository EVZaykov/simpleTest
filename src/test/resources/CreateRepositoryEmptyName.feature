Feature: Create repository from API
@login @api @all
  Scenario: Creating repository with empty name
  * User creates repository with name "" and saves response to var "responseAfterCreating"
  * User gets response "responseAfterCreating" and checks status code ER "422"
  * User gets value from JsonPath "errors.message" from response "responseAfterCreating" and saves to var "nameOfRepos"
  * User compare two variables "${nameOfRepos}" "[null, name is too short (minimum is 1 character)]"











