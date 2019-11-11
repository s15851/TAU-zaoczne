Feature: Rent a boat
  Customer rent a boat

  Scenario: Customer rent a boat
    Given Customer chooses a boat from list of boats for rent
    When Customer choose model "Antila 27"
    And Customer choose year of production 2009
    Then Boat has been rented and removed from list of boats for rent
    And Quantity of boats for rent has been reduced by 1