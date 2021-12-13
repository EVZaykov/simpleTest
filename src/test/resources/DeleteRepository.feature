Feature: Create repository from REST request and delete
@del @api @hello @all
  Scenario: name of repository with normal name
  * User deletes repository with name "-TestName-" and saves response to var "responseAfterDeleting"
  * User deletes repository with name "ValidName " and saves response to var "responseAfterDeleting"
  * User deletes repository with name "createAndSee  " and saves response to var "responseAfterDeleting"
  * User deletes repository with name "fromCon121" and saves response to var "responseAfterDeleting"
  * User deletes repository with name "fromJenkins12" and saves response to var "responseAfterDeleting"
  * User deletes repository with name "HelloNetherlands1  " and saves response to var "responseAfterDeleting"
  * User deletes repository with name "fromJenkins " and saves response to var "responseAfterDeleting"
  * User deletes repository with name "HelloNetherlands12 " and saves response to var "responseAfterDeleting"
  * User deletes repository with name "createAndSee1" and saves response to var "responseAfterDeleting"
  * User deletes repository with name "FDDSA" and saves response to var "responseAfterDeleting"
  * User deletes repository with name "HelloAmsterdam1 " and saves response to var "responseAfterDeleting"
  * User deletes repository with name "HelloNetherlands" and saves response to var "responseAfterDeleting"

  #* User gets value from JsonPath "name" from response "responseAfterDeleting" and saves to var "nameOfRepos"









