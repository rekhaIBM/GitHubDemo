Feature: Update a BG
@UpdateBG @DeleteBG
Scenario Outline: Update a BG by all filters
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And update the necessary details and edit BG by using Update button
	Then User should be able to update the BG successfully
	
#@UpdateBG @AdminRole
Scenario Outline: Update a BG by BG Name
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And update the BG Name and edit BG by using Update button
	Then User should be able to update the BG successfully
	
#@UpdateBG @AdminRole
Scenario Outline: Update a BG by Security
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And update the security and edit BG by using Update button
	Then User should be able to update the BG successfully
#@UpdateBG @AdminRole
Scenario Outline: Update a BG by Status
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And update the status and edit BG by using Update button
	Then User should be able to update the BG successfully	
	
#@UpdateBG @AdminRole
Scenario Outline: Update BG by Existing BG Name
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And update the Existing BG Name and edit BG by using Update button
	Then User should get BG Name Already Exists Warning	
	
#@UpdateBG @AdminRole
Scenario Outline: Update status to inactive, for BG linked to CMR Locks or BG Rules
	Given User should be in BG Tab and under BG By Client
	And fill Linked BG details to search the BG to be updated
	When User should select the BG to be updated
	And update the status to inactive and edit BG by using Update button
	Then User should get BG has one or more active rules Warning	
	
#@UpdateBG @AdminRole
Scenario Outline: Update BG without updating any field
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And update BG by using Update button
	Then User should get please commit changes before update Warning
	
#@UpdateBG @AdminRole
Scenario Outline: Change GBG for a BG
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And  update the new GBG by using Change GBG button and Submit
	Then User should be able to successfully change the GBG for the BG 	
	
#@UpdateBG @AdminRole
Scenario Outline: Change with same GBG for a BG
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And  update the GBG by using Change GBG button and Submit
	Then User should get Select a different GBG Warning message
#@UpdateBG @AdminRole
Scenario Outline: Copy a BG to another mandt
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And  copy the BG by using copy button and Submit
	Then User should be able to successfully copy the BG to another mandt
#@UpdateBG @AdminRole
Scenario Outline: Create BG Rules for a BG
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And Insert details and create BG Rules using Create BG Rule button and save
	Then User should be able to successfully Create BG Rules
	
#@UpdateBG @AdminRole
Scenario Outline: Validate warning messages for create BG Rules
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And Insert detail and create BG Rules using Create BG Rule button and save
	Then User should get record already exists message
	
#@UpdateBG @AdminRole
Scenario Outline: Copy BG Rules for different mandt
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And Select and Copy linked BG Rules using Copy Linked Rules button
	Then User should be able to successfully Copy BG Rules
	
#@UpdateBG @AdminRole
Scenario Outline: Delete BG Rules for a BG
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And Select and Delete linked BG Rules using Delete Linked Rules button
	Then User should be able to successfully Delete BG Rules
#@UpdateBG @AdminRole
Scenario Outline: Copy CMR Locks for different mandt
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And Select and Copy linked CMR locks using Copy Linked CMR button
	Then User should be able to successfully Copy CMR Locks
	
#@UpdateBG @AdminRole
Scenario Outline: Delete CMR Locks for a BG
	Given User should be in BG Tab and under BG By Client
	And fill details to search the BG to be updated
	When User should select the BG to be updated
	And Select and Delete linked CMR Locks using Delete Linked Rules button
	Then User should be able to successfully Delete CMR Locks