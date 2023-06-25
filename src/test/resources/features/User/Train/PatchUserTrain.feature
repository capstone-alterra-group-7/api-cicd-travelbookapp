Feature: PATCH USER TRAIN - Update Order ticket KA

  @PatchUT
  Scenario: as a user i want to  Update Order ticket KA
    Given user on Endpoint Login Valid Endpoint Train Update Order ticket KA
    When user Request Login Valid Endpoint Train Update Order ticket KA
    When user send update request with PUT method on Update Order ticket KA endpoint
    When user on the Update Order ticket KA endpoint
    Then system responds with the status code 201 OKK
    And data updated