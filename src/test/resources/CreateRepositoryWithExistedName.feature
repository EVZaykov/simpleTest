Feature: Create repository from API
@login @api @hello @all
  Scenario: Creating repository with existed name
  * User creates repository with name "lucky-day" and saves response to var "responseAfterCreating"
  * User gets response "responseAfterCreating" and checks status code ER "422"
  * User gets value from JsonPath "errors[0].message" from response "responseAfterCreating" and saves to var "nameOfRepos"
  * User compare two variables "${nameOfRepos}" "name already exists on this account"











