@task 
Feature: Create tasks 
@admin 
Scenario: Admin user ability to add tasks 
	Given User should logged in as admin user 
	And I am tasks tab 
	When I create Task 
	Then I should see the newly created task 
	
@nonadmin 
Scenario: Admin user ability to add tasks 
	Given User should logged in as admin user 
	And I am tasks tab 
	When I create Task 
	Then I should see the newly created task 
	
@sanity 
Scenario: Admin user ability to add Team 
	Given User should logged in as admin user 
	When User clicks on Team tab 
	Then User should see Aaron Assembler
	
@regression1 
Scenario: Admin user ability to add Accounts
	Given User should logged in as admin user
	When User clicks on Accounts tab
	Then User should see the Create Account link
	
@regression2 
Scenario: Admin user ability to add Campaigns
	Given User should logged in as admin user
	When User clicks on campaigns tab
	Then User should see the Create Campaigns link
	
@regression3 
Scenario: Admin user ability to add Leads
	Given User should logged in as admin user
	When User clicks on Leads tab
	Then User should see the Create Leads link	
	
@regression4 
Scenario: Admin user ability to add Contacts
	Given User should logged in as admin user
	When User clicks on Contacts tab
	Then User should see the Create Contacts link	
@regression5 
Scenario: Admin user ability to add Opportunities
	Given User should logged in as admin user
	When User clicks on Opportunities tab
	Then User should see the Create Opportunity link
	
@functional1 
Scenario: Admin user ability to create campaign
	Given User should logged in as admin user
	When User clicks on campaigns tab
	And User should see the Create Campaigns link
	Then User clicks on create campaign link
	Then Verify user is on create campaign page
	
@functional2
Scenario: Admin user ability to create leads
	Given User should logged in as admin user
	When User clicks on Leads tab
	And User should see the Create Leads link
	Then User clicks on create Lead link
	Then Verify user is on Create Lead page 
	
@endtoendtest
Scenario: Create lead and verify created lead
	Given User should logged in as admin user
	When User clicks on Leads tab
	Then User clicks on create Lead link
	And enter all the details
	And clicks on create lead button
	And verify created lead