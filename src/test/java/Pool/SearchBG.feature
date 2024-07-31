Feature: Search and Export BGs 

@SearchBG @ReadOnlyRole
Scenario: BG By All Filters
	Given User should be in BG Tab and under BG By Client
	When fill all details to search the BG
	Then User should be able to search and export BGs

@SearchBG @ReadOnlyRole
Scenario: BG BY Mandt
	Given User should be in BG Tab and under BG By Client
	When fill mandt to search the BG
	Then User should be able to search and export BGs
		
@SearchBG @ReadOnlyRole
Scenario: BG By BGID
	Given User should be in BG Tab and under BG By Client
	When fill BGID to search the BG
	Then User should be able to search and export BGs
	
@SearchBG @ReadOnlyRole
Scenario: BG By BGName
	Given User should be in BG Tab and under BG By Client
	When fill BGName to search the BG
	Then User should be able to search and export BGs

@SearchBG @ReadOnlyRole
Scenario: BG By CreatedBy
	Given User should be in BG Tab and under BG By Client
	When fill createdBy to search the BG
	Then User should be able to search and export BGs
	
@SearchBG @ReadOnlyRole
Scenario: BG without filters
	Given User should be in BG Tab and under BG By Client
	When leave all filters blank for BG
	Then User should be able to search and export BGs
	
@SearchBG @ReadOnlyRole
Scenario: BG By Mandt and BGID
	Given User should be in BG Tab and under BG By Client
	When fill mandt and BGID to search the BG
	Then User should be able to search and export BGs
	
@SearchBG @ReadOnlyRole
Scenario: BG By Mandt and BGName
	Given User should be in BG Tab and under BG By Client
	When fill mandt and BGName to search the BG
	Then User should be able to search and export BGs
	
@SearchBG @ReadOnlyRole
Scenario: BG By Mandt and BGID and BGName
	Given User should be in BG Tab and under BG By Client
	When fill mandt and BGID and BGName to search the BG
	Then User should be able to search and export BGs
	
@SearchBG @ReadOnlyRole
Scenario: BG By Mandt and GBGID and GBGName
	Given User should be in BG Tab and under BG By Client
	When fill mandt and GBGID and GBGName to search the BG
	Then User should be able to search and export BGs
	
@SearchBG @ReadOnlyRole
Scenario: BG By All Dropdowns
	Given User should be in BG Tab and under BG By Client
	When fill all dropdowns to search the BG
	Then User should be able to search and export BGs
	
	