Feature: Etsy Search Flow
  @etsy
  Scenario: Search Box Testing

    Given user is on Etsy page
    When user search Gold Necklace
    And user clicks on the first result
    Then user should see gold in product title

