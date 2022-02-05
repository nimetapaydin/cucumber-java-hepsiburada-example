Feature: Hepsiburada Login

  Scenario: Login And See
    Given I open "https://hepsiburada.com" link
    Given I click main login button
    When I login with "deneme@gmail.com" email and "1234" password
    Then I see my name
