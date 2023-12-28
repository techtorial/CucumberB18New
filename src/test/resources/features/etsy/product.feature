Feature: Testing the Search Product Functionality

  Background:Navigation to the website
    Given User navigates to 'https://www.etsy.com/'

  Scenario Outline: Search Functionality Happy Path for Etsy Hat
    When User searches '<productName>' for Etsy
    Then User validates the title '<expectedTitle>' from Etsy
    Examples:
      | productName | expectedTitle |
      | Hat         | Hat - Etsy    |
      | Key         | Key - Etsy    |
      | Pin         | Pin - Etsy    |

#Command+Option+L

  Scenario: Search Functionality Happy Path for Etsy Key
    When User searches for Etsy
      | productName | Key |
    Then User validates the title from Etsy
      | Key - Etsy |

#
#  Scenario: Search Functionality Happy Path for Etsy Pin
#    When User searches 'Pin' for Etsy
#    Then User validates the title 'Pin - Etsy' from Etsy