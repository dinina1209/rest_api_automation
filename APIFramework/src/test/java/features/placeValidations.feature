Feature: Validating Place API's

Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
    Given Add Place payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceAPI"
    
Examples:
	| name    | language   | address                   |
	| AAHouse | English-EN | 29, side layout, cohen 09 |
#  | BBHouse | Spanish-SP | Sea cross center					 |

Scenario: Verify If Delete Place functionality is working
	Given DeletePlace Payload
	When user calls "deletePlaceAPI" with "Post" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"