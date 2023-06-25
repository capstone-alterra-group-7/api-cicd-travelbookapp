Feature: Get - search Train available

  @GetSTA
  Scenario: as a user i want to get data search Train available
    Given input Endpoint Login Valid Endpoint search Train available
    When input  Request Login Valid Endpoint search Train available
    When user on the search train available endpoint
    When user create request with GET method on search train available endpoint
    Then get status code 200 OKEE
    And get valid data train available

  @GetSTA-1
  Scenario: as a user i want to get data search Train available with invalid id
    Given input Endpoint Login Valid Endpoint search Train available
    When input  Request Login Valid Endpoint search Train available
    When user on the search train available endpoint with invalid id
    When user create request with GET method on search train available endpoint with invalid id
    Then get status code 200 OK succes
    And get data train available

  @GetSTA-2
  Scenario: as a user i want to get data search Train available with id 0
    Given input Endpoint Login Valid Endpoint search Train available
    When input  Request Login Valid Endpoint search Train available
    When user on the search train available endpoint with id 0
    When user create request with GET method on search train available endpoint with id 0
    Then get status code 400 bad request
    And failed to get data train available

  @GetSTA-3
  Scenario: as a user i want to get data search Train available with invalid token
    Given input Endpoint Login Valid Endpoint search Train available
    When input  Request Login Valid Endpoint search Train available
    When user on the search train available endpoint with invalid token
    When user create request with GET method on search train available endpoint with invalid token
    Then get status code 401 unautorized
    And failed to get data STA