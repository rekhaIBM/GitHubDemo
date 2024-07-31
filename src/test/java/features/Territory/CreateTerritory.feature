Feature: Create a New Territory ID 

@CreateTerritory
Scenario Outline: Create Territory ID using all field
	Given User should be in Territory module under COV Structure Tab and click Add button
	When User should fill all details with valid data and create new Territory ID by clicking on insert button 
	Then User should be able to create new territory ID successfully for valid data 
