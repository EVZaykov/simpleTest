Feature: Create repository from REST request and delete
@inWork
  Scenario: Create repository from REST request
  * User creates repository with name "createAndSee1" and saves response to var "responseAfterCreating"
  * User gets response "responseAfterCreating" and checks status code ER "201"
  * User gets value from JsonPath "name" from response "responseAfterCreating" and saves to var "nameOfRepos"
  * User checks all params in response "responseAfterCreating"
      | full_name | EVZaykov/${nameOfRepos}                                            |
      | url       | https://api.github.com/repos/EVZaykov/${nameOfRepos}               |
      | keys_url  | https://api.github.com/repos/EVZaykov/${nameOfRepos}/keys{/key_id} |
  * User opens browser "EVZaykov/${nameOfRepos}"









