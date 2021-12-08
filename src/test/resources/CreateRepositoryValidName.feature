Feature: Create repository from API
@login @api @hello @all
  Scenario: Creating repository with valid name
  * User creates repository with name "ValidName" and saves response to var "responseAfterCreating"
  * User gets response "responseAfterCreating" and checks status code ER "201"
  * User gets value from JsonPath "name" from response "responseAfterCreating" and saves to var "nameOfRepos"
  * User compare two variables "${nameOfRepos}" "ValidName"
  * User deletes repository with name "${nameOfRepos}" and saves response to var "responseAfterDeleting"
  * User gets response "responseAfterDeleting" and checks status code ER "204"











