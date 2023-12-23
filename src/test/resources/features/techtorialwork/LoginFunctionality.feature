@smoke @regression
Feature: Testing the Login Functionality of Techtorial Work Website

  Background: Validates title and visibility of log_in
    Given User validates the title is 'techtorial' from LoginPage
    And User validates the log_in is visible on the page

  Scenario:Happy Path Login Functionality(Positive)
#  Given User validates the title is 'techtorial' from LoginPage
#  And User validates the log_in is visible on the page
  When User provides username and password to the loginPage
  Then User validates the title 'Dashboard' from MainPage

Scenario: Negative Login Functionality(Incorrect email and password)
#  Given User validates the title is 'techtorial' from LoginPage
#  And User validates the log_in is visible on the page
  When User provides 'ahmet@example.com' and '234234' to the loginPage
  Then User validates 'These credentials do not matches our records.' and 'rgba(211, 0, 0, 1)' from loginPage






#navigate to url: https://techtorialwork.com/worksuit/public/login
#Verify the title is "techtorial"
#Verify "Log In" is visiable on the page
#Enter correct email and password
#Click login button
#Verify title is "Dashboard"

#  navigate to url: https://techtorialwork.com/worksuit/public/login
#  Verify the title is "techtorial"
#  Verify "Log In" is visiable on the page
#  Enter incorrect email and password
#  Click login button
#  "Verify error message is displayed ""These credentials do not match our records.
#  "" in red color."