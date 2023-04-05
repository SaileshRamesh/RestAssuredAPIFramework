package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@VerifyDeletePlaceAPI")
	public void beforeScenario() throws IOException {
		PlaceValidationStepDef placeValidationStepDef = new PlaceValidationStepDef();
		if (PlaceValidationStepDef.place_id == null) {
			placeValidationStepDef.add_place_payload_with_and("Sailesh SDET", "French", "Asia");
			placeValidationStepDef.user_calls_with_http_request("AddPlaceAPI", "POST");
			placeValidationStepDef.verify_place_id_created_maps_to_using("Sailesh SDET", "getPlaceAPI");
		}
	}

}
