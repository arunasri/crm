Feature: Create Leads
@endtoendtest
Scenario Outline: Create lead and verify created lead
	Given user should logged in as admin user
	When user clicks on Leads tab
	Then user clicks on create Lead link
	Then enter all the details "<firstname>" and "<lastname>" and "<email>" and "<phone>"
	Then clicks on create lead button
	Then verify created lead	
	
Examples:
	| firstname  | lastname | email 			| phone 	 |
	|  Adam		 |	vim	    | test@gmail.com	| 1234567890 |
	
