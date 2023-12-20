Feature: Testing Adding Products Functionality in TechtorialWork Website

  Scenario: Happy Path Product Addition Functionality
    Given User provides username and password to the loginPage
    When User clicks Products Button on the left side and AddProductButton from ProductPage
    And User provides 'Truck-Mounted Crane' and '15000' to the product details boxes
    And User selects 'Lifting and Material Handling Equipment','Mobile Cranes',and 'Federal Tax:10%' from drop-downs
    And User clicks purchase check box and add 'It is a good product' into the description
    And User provides picture 'location' and click save button
    Then User validates product details 'true','Truck-Mounted Crane','16500','Allowed' from table

