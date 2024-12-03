package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		//write a code that will give you a place_id
		//execute this code only when place_id is null
		
		StepDefinition sd = new StepDefinition();
		if(StepDefinition.place_id == null) {
			sd.add_Place_Payload_with("Dini", "English-EN", "New Zealand");
			sd.user_calls_with_Post_http_request("AddPlaceAPI", "POST");
			sd.verify_place_id_created_maps_to_using("Dini", "getPlaceAPI");
		}
	}
}
