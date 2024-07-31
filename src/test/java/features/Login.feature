Feature: Login to RMT application

	@Login
  Scenario Outline: Login to RMT application and verify the user
    Given User is on RMT Landing page
    When User should login to the RMT application with username and password and enter submit button
    Then User should redirect to the homescreen of RMT application

      
