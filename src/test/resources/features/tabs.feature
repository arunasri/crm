@task 
Feature: Create all tabs available in Fat Free CRM website 
@newtest 
Scenario Outline: User able to create account 
	Given user should logged in as admin 
	When user clicks on accounts tab 
	Then user clicks on create account link 
	And enter all the details "<name>" and "<assignedto>" and "<category>" and "<rating>" 
	And clicks on create account button 
	And verify created account user details 
	
	Examples: 
		| name    | assignedto | category | rating |
		| Adamsp  | Myself     | Partner  |  2     |
		
		@accounttest 
		Scenario: Enter all the fields in create account page 
			Given user should logged in as admin 
			When user clicks on account tab 
			And user clicks on Create Account link 
			And user enters all the fields 
			And click create account button 
			Then verify created account user details 
			
		@assert 
		Scenario: Assertions 
			Given user should logged in as admin 
			When verify home page tags 
			Then verify edit link 
			And verify delete link 
		@verify 
		Scenario: Verify all elements present on create task page 
			Given user should be logged in 
			When user clicks on task tab and clicks on create task link 
			Then user should verify all the elements present in create task page 
		@newtask 
		Scenario Outline: Create task page 
			Given user should be logged in 
			When user clicks on task tab and clicks on create task link 
			Then user should enter "<name>" and "<due>" and "<assignto>" and "<category>" 
			Examples: 
				| name   | due       | assignto      | category |
				| david  | Tomorrow  | 	Dan Debugger | Call     |
				| tom    | Next Week | Cindy Cluster | Email    |
				@newcontact 
				Scenario Outline: Create Contact page 
					Given user should be logged in 
					When user clicks on contacts tab and clicks on create contacts link 
					Then user should enter "<firstname>" and "<lastname>" and "<email>" and "<phone>" and "<account>" and "<assignto>" 
					Examples: 
						| firstname | lastname    | email           | phone      |  account  |   assignto       |
						| Emma      | jones       | test1@gmail.com | 1112223333 |           |  Aaron Assembler |
						| David     | williams    | test2@gmail.com | 4443332222 |           | Ben Bootloader   |
						
						@newopportunity 
						Scenario Outline: Create Opportunity page 
							Given user should be logged in 
							When user clicks on opportunities tab and clicks on create opportunity link 
							And user should enter "<name>", "<stage>", "<closedate>", "<probability>", "<amount>", "<discount>", "<account>", "<assignedto>", "<campaign>" 
							Then verify new opportunity with "<name>" created 
							Examples: 
								| name   | stage        | closedate   | probability | amount | discount | account | assignedto      | campaign                |
								| Dave   | Presentation | 2017-12-20  | 50          | 1000   |  2       | dave    | George Globals  | Be all that you can be  |
								| Rachel | Final Review | 2017-12-25  | 70          | 2000   |  3       | rachel  | Frank Formatter | Because I'm worth it    |
	