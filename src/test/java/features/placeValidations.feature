@Regression @Smoke 
Feature: Validating Place API's 

@VerifyAddPlaceAPI	
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI 
	Given Add place payload with "<name>" "<language>" and "<address>"
	When User calls "AddPlaceAPI" with "POST" http request 
	Then the API call is success with status code 200 
	And "status" in response body is "OK"
	And "scope" in response body is "APP" 
	And verify place_Id created maps to "<name>" using "getPlaceAPI"
	
Examples:
    |name                    |language    | address                   |
    |Sailesh Home Automation | French-IN  | 29, side layout, cohen 09 |
#	|Sailesh Ramesh SDET     | English-IN | 17, Bangalore, Kar 56     |

@VerifyDeletePlaceAPI	
Scenario: Verify if Delete Place functionality is working
    Given DeletePlace payload
    When User calls "deletePlaceAPI" with "POST" http request 
    Then the API call is success with status code 200 
    And "status" in response body is "OK"