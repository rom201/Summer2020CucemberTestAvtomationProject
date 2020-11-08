@login
Feature: As user I want to be able to login under different roles

  #this is comment

  Background: common steps
    Given user is on the login page
    # for all scenarios in this feature

  @simple
  Scenario: Login as a sales manager
    When user logs in
    Then user should see dashboard page

  @parametrized_test
  Scenario: Parametrized login
    When user logs in as "sales manager"
    Then user should see dashboard page
    #"driver" is parameter "" allows to do parametrization

  @s_o
  Scenario Outline: Parametrized login as <role>
    When  user logs in as "<role>"
    Then user should see dashboard page
    Examples:
      | role          | // works as variable
      | sales manager | // will be executed two times   1
      | driver        | //    2
      | store manager | //    3


  @with_two_columns
  Scenario Outline: Parametrized login as <role>
    When  user logs in as "<role>"
    Then user should see "<page title>" page
    Examples:
      | role          | page title      |
      | store manager | Dashboard       |
      | driver        | Quick Launchpad |
      | sales manager | Dashboard       |


  @negative_login
  Scenario: Invalid password
    When user logs in with "storemanager218" username and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed


  @negative_outline
  Scenario Outline: Invalid login with <username> and <password>
    When user logs in with "<username>" username and "<password>" password
    Then user verifies that "<message>" message is displayed
    Examples: data set
      | username | password | message                        |
      | wrong    | bed      | Invalid user name or password. |
      | wrong    | bed      | Invalid user name or password. |