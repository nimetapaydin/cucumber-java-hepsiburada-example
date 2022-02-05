Feature: Hepsiburada Search

  Scenario: when I searching freezer then I should see freezer result
    Given I open "https://hepsiburada.com" link
    Given I click search input
    Given I type "buz dolabı" in search input
    When I click search button
    Then I should see "buz dolabı" products in suggest list
