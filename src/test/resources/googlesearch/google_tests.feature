Feature: Google tests sample
  Basic Google smoke tests

  Scenario Outline: Google search
    Given I navigate to Google home page
    When I type search pattern "<pattern>"
    And I click on Search button
    Then I found match

    Examples:
      | pattern |
      | HBO |
      | ABC |
      | FOX |
      | CNN |
