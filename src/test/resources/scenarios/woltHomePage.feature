Feature: Banner on the Wolt homepage
         As a user I want to see a banner on the Wolt homepage

  Background: I must be on the homepage of the site
    Given user open the website "https://wolt.com/en/ltu"
    And   user see cookie window
    When  user click the cookie confirmation button
    Then  user should see the cookie window disappear

  @Scenario1
  Scenario: User sees the page title in Lithuania
    Given user is on the Wolt homepage
    Then  user should see that page title as "Wolt Delivery: Food and more – Lithuania"

  @Scenario2
  Scenario: User sees banner with advertisement
    Given user is on the Wolt homepage
    When  the page loads
    Then  user should see a banner with an advertisement
    And   user should see a link to popular restaurants
    And   user should see a delivery address search field

  @Scenario3
  Scenario: User clicks a link popular restaurant
    Given user is on the Wolt homepage
    And   user should see a link to popular restaurants
    When  user clicks on the link
    Then  user should be redirected to the restaurants page in Vilnius

  @Scenario4
  Scenario Outline: User can check delivery address
    Given user is on the Wolt homepage
    And   user should see a delivery address search field
    When  user enters "<deliveryAddress>" in the input field
    And   user presses Enter
    Then  user should be redirected to the "<deliveryAddress>"

    Examples:
      | deliveryAddress |
      | Riga            |
      | Kaunas          |
      | Vilnius         |


