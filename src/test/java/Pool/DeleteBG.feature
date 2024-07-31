Feature: Delete a BG 

@DeleteBG @AdminRole
Scenario Outline: Delete BG
	Given User should be in Delete Clients Tab and under Delete BGs
	And fill details to search BG to be deleted  
	When User should select the BG and delete it by using Delete Button 
	Then User should be able to delete the BG successfully


		
		