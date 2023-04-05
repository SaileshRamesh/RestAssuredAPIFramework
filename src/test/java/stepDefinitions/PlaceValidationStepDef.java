package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class PlaceValidationStepDef extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String place_id;
	TestDataBuild data = new TestDataBuild();

	@Given("Add place payload with {string} {string} and {string}")
	public void add_place_payload_with_and(String name, String language, String address) throws IOException {
		res = given().spec(requestSpecification()).body(data.addPlacePayLoad(name, language, address));
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String request) {
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (request.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource());
		else if (request.equalsIgnoreCase("GET"))
			response = res.when().get(resourceAPI.getResource());
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		assertEquals(getJsonResponseValue(response, keyValue), expectedValue);
	}

	@And("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		place_id = getJsonResponseValue(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		assertEquals(getJsonResponseValue(response, "name"), expectedName);
	}

	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
		res = given().spec(requestSpecification()).body(data.deletePlacePayLoad(place_id));
	}

}
