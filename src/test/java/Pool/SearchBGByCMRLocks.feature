Feature: Search and Export BGs by CMR Locks

@SearchBGByLocks @ReadOnlyRole
Scenario: Search BG By CMR Locks By All Filters
	Given User should be in BG Tab and under BG By CMR Locks
	When fill all details to search the BG by CMR Locks
	Then User should be able to search and export BGs by CMR Locks
	
@SearchBGByLocks @ReadOnlyRole
Scenario: Search BG By CMR Locks By Mandt
	Given User should be in BG Tab and under BG By CMR Locks
	When fill mandt to search the BG by CMR Locks
	Then User should be able to search and export BGs by CMR Locks
	
@SearchBGByLocks @ReadOnlyRole
Scenario: Search BG By CMR Locks By BGID
	Given User should be in BG Tab and under BG By CMR Locks
	When fill BGID to search the BG by CMR Locks
	Then User should be able to search and export BGs by CMR Locks
	
@SearchBGByLocks @ReadOnlyRole
Scenario: Search BG By CMR Locks By Kunnr To Lock
	Given User should be in BG Tab and under BG By CMR Locks
	When fill KunnrToLock to search the BG by CMR Locks
	Then User should be able to search and export BGs by CMR Locks
	
@SearchBGByLocks @ReadOnlyRole
Scenario: Search BG By CMR Locks By Created By
	Given User should be in BG Tab and under BG By CMR Locks
	When fill CreatedBy to search the BG by CMR Locks
	Then User should be able to search and export BGs by CMR Locks