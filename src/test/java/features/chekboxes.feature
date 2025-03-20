Feature: Checkbox Selection

  Scenario: Verify checkboxes can be selected and deselected
    Given I open the checkboxes page
    When I check the first checkbox
    Then The first checkbox should be checked
    When I uncheck the second checkbox
    Then The second checkbox should be unchecked