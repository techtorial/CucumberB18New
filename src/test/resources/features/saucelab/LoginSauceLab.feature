
  Feature: Testing Login Functionality for SauceLab
    Background: Navigation
      Given User navigates to the 'https://www.saucedemo.com/'

  Scenario: Happy Path Login
    When User provides 'username' and 'password' to the SauceLoginPage
    Then User validates the 'title' from SauceMainPage
