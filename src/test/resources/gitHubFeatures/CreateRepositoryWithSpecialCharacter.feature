Feature: Create repository from API
@login @api
  Scenario: Creating repository with special character in name
  * User creates repository with name "@TestName@" and saves response to var "responseAfterCreating"
  * User gets response "responseAfterCreating" and checks status code ER "201"
  * User gets value from JsonPath "name" from response "responseAfterCreating" and saves to var "nameOfRepos"
  * User compare two variables "${nameOfRepos}" "-TestName-"
  * User deletes repository with name "${nameOfRepos}" and saves response to var "responseAfterDeleting"
  * User gets response "responseAfterDeleting" and checks status code ER "204"











