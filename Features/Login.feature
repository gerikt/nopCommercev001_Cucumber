
Feature: Login
  

  
  Scenario: Successful Login with Valid Credentials
    Given User Launch Edge browser
    When user opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then Page Title should be  "Dashboard / nopCommerce administration"
    When user click on Log out link
    And close browser
  
Scenario Outline: Login Data Driven
    Given User Launch Edge browser
	  When user opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enters Email as "<email>" and Password as "<password>"
    And click on Login
    Then Page Title should be  "Dashboard / nopCommerce administration"
    When user click on Log out link
    And close browser

    
    Examples:
    	| email | password |
     	| admin@yourstore.com | admin |
     	| admin1@yourstore.com | admin123 |

    	