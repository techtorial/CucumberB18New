Feature: Testing Login Functionality for SauceLab

  Background: Navigation
    Given User navigates to the 'https://www.saucedemo.com/'

  Scenario Outline: Happy Path Login
    When User provides '<username>' and '<password>' to the SauceLoginPage
    Then User validates the '<title>' from SauceMainPage
    Examples:
      | username                | password     | title     |
      | standard_user           | secret_sauce | Swag Labs |
      | problem_user            | secret_sauce | Swag Labs |
      | performance_glitch_user | secret_sauce | Swag Labs |
      | error_user              | secret_sauce | Swag Labs |
      | visual_user             | secret_sauce | Swag Labs |