Feature: Customers

  Scenario: Add a new Customer
    Given User Launch Edge browser
  When user opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then User can view Dashboard
    When User click on customers Menu
    And click on customers Menu Item 
    And click on customers
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view configuration message "The new customer has been added successfully."
    And close browser
    
 