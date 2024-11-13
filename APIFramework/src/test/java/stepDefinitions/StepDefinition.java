package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

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


public class StepDefinition {
	ResponseSpecification resSpec;
	RequestSpecification res;
	Response response;
	
	@Given("Add Place Payload")
	public void add_Place_Payload() {
		
		//from SpecBuilderTest
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		//creating place object using POJO
		AddPlace place = new AddPlace();
		place.setAccuracy(50);
		place.setAddress("&quot;29, side layout, cohen 09");
		place.setLanguage("French-IN");
		place.setPhone_number("(+91) 983 893 3937");
		place.setWebsite("http://google.com");
		place.setName("Frontline house");
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		place.setTypes(myList);
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		place.setLocation(loc);
		
		//RequestSpecification
		RequestSpecification req = new RequestSpecBuilder()
		.setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON)
		.build();
		
		//ResponseSpecification
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		res = given().spec(req).body(place);
	}
	
	@When("user calls {string} with Post http request")
	public void user_calls_with_Post_http_request(String string) {
		response = res.when().post("/maps/api/place/add/json")
				.then().spec(resSpec).extract().response();
	}
	
	@Then("the API call gout success with status  code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
		
	}
	
	@Then("{string} is reponse body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		assertEquals(js.get(keyValue).toString(), expectedValue);
	}
}
