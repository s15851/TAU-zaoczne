Feature: Quantity of rented boats
  Tenant wants to know quantity of rented boats

  Scenario: Rent a boat
    Given rental of 1 boat
    When boat has been rented
    Then quantity of rented boats has been increased by 1