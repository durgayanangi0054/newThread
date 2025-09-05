Feature: Rahul Shetty Academy Login
@smoke
Scenario Outline: login attempt 
    Given I am on the Rahul Shetty Academy login page
    When I enter username "<username>" and password "<password>"
    And I click the login button
    Then I should be redirected to the homepage
    
    
    Examples:
    	| username                      | password       | 
      | satyadurgayanangi@gmail.com   | Durga@123			 | 
      | satyadurgayanangi@gmail.com   | Durga@123		   | 
      | satyadurgayanangi@gmail.com   | Durga@123		   | 