@regression
Feature: Testing Adding Products Functionality in TechtorialWork Website

  Scenario: Happy Path Product Addition Functionality
    Given User provides username and password to the loginPage
    When User clicks Products Button on the left side and AddProductButton from ProductPage
    And User provides 'Truck-Mounted Crane' and '15000' to the product details boxes
    And User selects 'Lifting and Material Handling Equipment','Mobile Cranes',and '1' from drop-downs
    And User clicks purchase check box and add 'It is a good product' into the description
    And User provides picture '/Users/techtorial/Downloads/usa.png' and click save button
    Then User validates product details 'Truck-Mounted Crane','$16,500.00','Allowed' from table

Scenario: Happy Path Product Filter Functionality
  Given User provides username and password to the loginPage
  When User clicks Products Button
  And User selects 'Lifting and Material Handling Equipment' and 'Mobile Cranes' for categories
  And User clicks three dots and view button from ProductPage
  Then User validates 'Lifting and Material Handling Equipment' and 'Mobile Cranes' from action view

