package stepDefinitions;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;


public class StepDefinition extends Utils{
	ResponseSpecification resSpec;
	RequestSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;
	
	@Given("Add Place payload with {string} {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {
		res = given().spec(requestSpecification())
			 .body(data.addPlacePyaload(name, language, address));
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_Post_http_request(String resource, String method) {
		APIResources resourceAPI = APIResources.valueOf(resource);
		
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST")) {
			response = res.when().post(resourceAPI.getResource());
		} 
		else if (method.equalsIgnoreCase("GET")) { 
			response = res.when().get(resourceAPI.getResource());
		}
	}
	
	@Then("the API call gout success with status  code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
	}
	
	@Then("{string} is reponse body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {		
		assertEquals(getJsonPath(response, keyValue), expectedValue);
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	    //requestSpec
		place_id = getJsonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_Post_http_request(resource, "GET");
		String actualName = getJsonPath(response, "name");
		assertEquals(actualName, expectedName);
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    res= given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}
	





}
