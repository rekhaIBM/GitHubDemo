Feature: Create then update as Inactive then delete the same BG 
		
@E2E
Scenario Outline: Create then update as Inactive then delete the same BG 
	Given User should create the new Buyng Group from RMT
	When User should update the Buyng Group as inactive from RMT
	Then User should delete the same Buyng Group from RMT
	And User should be able to delete the same BG successfully