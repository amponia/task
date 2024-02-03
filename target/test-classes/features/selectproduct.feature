Feature: Select product and add to cart

  @smartwatches
  Scenario: selecting product from smartwatches and wristbands category and adding to cart
    Given that I navigate to T-Mobile homepage
    And I accept cookies button
    Then I should see T-Mobile homepage
    And I select Devices from main header menu
    Then I should see dropdown list from Devices menu
    Given I select No subscription from Smartwatches and writsbands submenu
    Then I should see devices displayed
    Given I select first item from the displayed menu

    //TODO
    Then I should see the selected item details
    Given I add item to cart
    Then cart page should be displayed
    And "To be paid at start" and "To be paid monthly" prices should match prices on previous page
    Given that I go back to T-Mobile homepage
    Then I should see T-Mobile homepage with cart updated with <int> product

