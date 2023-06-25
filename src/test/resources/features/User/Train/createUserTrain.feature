Feature: UserTrain - Order Tiket KA

  @Usertrain1-TC+
  Scenario: Create New Order ticket KA
    Given Enter Endpoint Login Valid Endpoint Order ticket KA
    When Enter Request Login Valid Endpoint Order ticket KA
    When user on the create new Order ticket KA endpoint
    When user create request with POST method on Order ticket KA endpoint
    Then system responds with the status code 201 OK
