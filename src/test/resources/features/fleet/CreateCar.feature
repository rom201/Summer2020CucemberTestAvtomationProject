Feature: As user, I want to be able to create new cars


  @add_car  @Smoke
  Scenario: 1. Add some car
    Given user is on the login page
    And user logs in as "store manager"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
      | License Plate | SDET |
      | Model Year    | 2021 |
    And user clicks on save and close button


  @add_car_scenario_outline @Smoke
  Scenario Outline: Add some car with <license plate>
    Given user is on the login page
    And user logs in as "<role>"
    And user navigates to "Fleet" and "Vehicles"
    And user clicks on create car button
    When user adds new vehicle information
      | License Plate | <license plate> |
      | Model Year    | <model year>    |
    And user clicks on save and close button

    Examples: cars test data
      | license plate | model year | role          |
      | FLORIDA       | 2020       | store manager |
      | QA            | 2021       | store manager |
      | RAMAZAN       | 2021       | store manager |


