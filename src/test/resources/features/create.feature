Feature: Create tasks 
@admin 
Scenario: Admin user ability add tasks 
	Given I logged in as admin user 
	And I am tasks tab 
	When I create Task 
	Then I should see the newly created task 
	
@nonadmin 
Scenario: Admin user ability add tasks 
	Given I logged in as admin user 
	And I am tasks tab 
	When I create Task 
	Then I should see the newly created task 
	
@sanity
Scenario: Admin user ability add Team 
	Given I logged in as admin user 
	When User clicks on Team tab 
	Then User should see Aaron Assembler