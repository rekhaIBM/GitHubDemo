Feature: Search Territory ID for CT GUI App
		
#@SearchTerritory
Scenario: Search Territory ID from all field
	Given User should be in Territory module under COV Structure Tab
	When Fill all the details to search Territory id 
	Then User should be able to search
	
#@SearchTerritory
Scenario: Search Territory ID from mandt
	Given User should be in Territory module under COV Structure Tab
	When Fill mandt detail to search Territory id 
	Then User should be able to search
	
#@SearchTerritory
Scenario: Search Territory ID from coverageid
	Given User should be in Territory module under COV Structure Tab
	When Fill coverageid detail to search Territory id 
	Then User should be able to search
	
#@SearchTerritory
Scenario: Search Territory ID from coverageidname
	Given User should be in Territory module under COV Structure Tab
	When Fill coverageidname detail to search Territory id 
	Then User should be able to search
	
#@SearchTerritory
Scenario: Search Territory ID from execName
	Given User should be in Territory module under COV Structure Tab
	When Fill execName detail to search Territory id 
	Then User should be able to search
	
#@SearchTerritory
Scenario: Search Territory ID from ExecCnum
	Given User should be in Territory module under COV Structure Tab
	When Fill ExecCnum detail to search Territory id 
	Then User should be able to search
	
@SearchTerritory
Scenario: Search Territory ID from execIntranetId
	Given User should be in Territory module under COV Structure Tab
	When Fill execIntranetId detail to search Territory id 
	Then User should be able to search
	
	
	
