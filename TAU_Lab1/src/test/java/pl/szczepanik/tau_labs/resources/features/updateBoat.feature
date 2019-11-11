Feature: Change boat year of production

  Scenario: Update boat year of production becouse after adding new record to DB with entered wrong year
    Given Added new boat "Antila 27" to DB with wrong year of production
    When Boat year of production should be updated to 2019
    Then Boat have a new year of production