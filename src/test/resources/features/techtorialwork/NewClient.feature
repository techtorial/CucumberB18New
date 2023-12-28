@regression
Feature: Testing New Client Create,Search and Order Functionality

  Scenario: Happy Path create functionality for new client
    Given User provides username and password to the loginPage
    When User clicks Clients button
    And User clicks add client and provides 'John Doe', 'john.doe788@example.com','United States','3147353233' for ClientPage
    And User provides company information 'Doe Construction Inc.','https://www.doeconstruction.com','31442423322'
    And User provides address information '456 Oak Avenue, Springfield, IL, 62701','789 Birch Lane, Springfield, IL, 62702'
    Then User clicks save button and validates 'John Doe','Doe Construction Inc.','john.doe788@example.com','Active' from table.

#  Scenario Outline: Happy Path create functionality for new client with Scenario Outline
#    Given User provides username and password to the loginPage
#    When User clicks Clients button
#    And User clicks add client and provides '<fullName>', '<email>','<country>','<mobile>' for ClientPage
#    And User provides company information '<companyName>','<companyWebsite>','<companyPhone>'
#    And User provides address information '<companyAddress>','<shippingAddress>'
#    Then User clicks save button and validates '<fullName>','<companyName>','<email>','<status>' from table.
#    Examples:
#      | fullName     | email                    | country       | mobile     | companyName           | companyWebsite                  | companyPhone | companyAddress                         | shippingAddress                        | status |
#      | John Doe     | john.doe868@example.com  | United States | 3147353233 | Doe Construction Inc. | https://www.doeconstruction.com | 31442423322  | 456 Oak Avenue, Springfield, IL, 62701 | 789 Birch Lane, Springfield, IL, 62702 | Active |
#      | Ahmet Baldir | ahmet.doe869@example.com | Turkey        | 2342342342 | Ahmet Baldir company  | https://www.ahmetbaldir.com     | 33453453434  | 567 Oak Avenue, Springfield, IL, 62701 | 123 Birch Lane, Springfield, IL, 62702 | Active |

#  Scenario: Happy Path create functionality for new client with DataTable
#    Given User provides username and password to the loginPage
#    When User clicks Clients button
#    And User clicks add client and provides personal information
#      | name    | John Doe                |
#      | email   | john.doe989@example.com |
#      | country | United States           |
#      | mobile  | 3147353233              |
#    And User provides company information
#      | companyName    | Doe Construction Inc.           |
#      | companyWebsite | https://www.doeconstruction.com |
#      | companyPhone   | 31442423322                     |
#    And User provides address information
#      | 456 Oak Avenue, Springfield, IL, 62701 |
#      | 789 Birch Lane, Springfield, IL, 62702 |
#    Then User clicks save button and validates information
#      | John Doe                |
#      | Doe Construction Inc.   |
#      | john.doe989@example.com |
#      | Active                  |


#  TC 6    Validate adding new client
#  navigate to url: https://techtorialwork.com/worksuit/public/login
#  Enter correct email and password
#  Click login button
#  Click Clients on the left side of the page
#  Click Add client button
#  "Enter a client details with the following information:
#  (You can also create your own mock data)
#
#  Name: John Doe
#  Email: john.doe@example.com
#  Country: United States
#  Phone Number: +1 (555) 123-4567
#
#  Company Information:
#  Name: Doe Construction Inc.
#  Email: contact@doeconstruction.com
#  Website: http:\www.doeconstruction.com
#  Phone: (555) 001-2345
#  Address: 456 Oak Avenue, Springfield, IL, 62701
#  Shipping Address: 789 Birch Lane, Springfield, IL, 62702"
#  Click Save button
#  Verify Client information is saved


