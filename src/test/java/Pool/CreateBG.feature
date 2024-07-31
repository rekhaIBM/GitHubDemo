Feature: Create a New BG functionality

  #@CreateBG @AdminRole
  Scenario Outline: Create Buying Group
    Given User should be in BG Tab and create new BG by using new button
    When User should fill BGName and other details with valid data and create new BG by Submit the details
    Then User should be able to create a new BG successfully for valid data

  #@CreateBG @AdminRole
  Scenario Outline: Create Buying Group with mandatory field
    Given User should be in BG Tab and create new BG by using new button
    When User should fill all the mandatory details with valid data for create new BG
    Then User should be able to create a new BG successfully for valid data

  #@CreateBG @AdminRole
  Scenario Outline: Create Buying Group with mandatory field
    Given User should be in BG Tab and create new BG by using new button
    When User should not fill details and try to create the BG create new BG after each mandatory field and validate each error message
    Then User should be able to create a new BG successfully for valid data

  #@CreateBG @AdminRole
  Scenario Outline: Create Buying Group with wrong GBG ID
    Given User should be in BG Tab and create new BG by using new button
    When User should select mandt and enter wrong GBG name and GBG Id
    Then User should not be display any GBG id and not able to create BG

  @CreateBG
  Scenario Outline: Create Buying Group with wrong GBG ID sfdsf
    Given User should be in BG Tab and create new BG by using new buttonsdfsdf
    When User should select mandt and enter wrong GBG name and GBG Idsdfsd
    Then User should not be display any GBG id and not able to create BGsfsfsfs
