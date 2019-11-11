Feature: Is it Tango 780?
  Tenant wants to know what model of boat is it

  Scenario Outline: It is Tango 780 or not
    Given this is "<model>"
    When I ask you, are you sure it's Tango 780
    Then I should be told "<answer>"

  Examples:
    | model     | answer |
    | Antila 27 | No     |
    | Tango 780 | Yes    |
    | Phila     | No     |
