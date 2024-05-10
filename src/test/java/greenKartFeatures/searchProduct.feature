Feature: Search and Place order for products

  @OffersPage
  Scenario Outline: Search experience for product search in Home and Offers page
    Given User is on Greenkart landing page
    When user searches with short name <Name> and extracted actual name of product
    Then user searches for <Name> in Offers Page
    And Validate product name matches in Offers page

    Examples: 
      | Name |
      | Tom  |
      | Beet |
      | Pot  |
