Feature: Wolt homepage

  Background: I must be on the homepage of the site
    Given I open the website "https://wolt.com/en/ltu"
     And  I see cookie window
    When  I click the cookie confirmation button
    Then  I should see the cookie window disappear

  Scenario: Check Homepage banner
    When I see that the page title as "Wolt Delivery: Food and more – Lithuania"
     And Banner on the home page should be displayed
     And link to popular restaurants is displayed
     And delivery address search field is displayed
    When I input "Riga" in 'Search' textfield
    Then I expect to see dropdown with all suggested addresses

