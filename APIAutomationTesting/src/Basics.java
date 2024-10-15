import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;

public class Basics {

	public static void main(String[] args) {
		//Validate if Add Place API is working as expected
		//Task : Add place -> update place with new adds -> Get place to validate if new adds is added
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		//Task1 ) Add Place
		// Given - All input details - POST call
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(payload.AddPlace())
		// When - Submit the API - resource, http method
		.when().post("maps/api/place/add/json")
		// Then - Validate the response
		.then().assertThat()
		.statusCode(200)
		//validate if body includes key(scope) and value(APP)
		.body("scope", equalTo("APP"))
		//validate if Header includes key(Server) and value(Apache/2.4.52 (Ubuntu))
		.header("Server", "Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		
		System.out.println(response);
		
		//JsonPath : take String as an input -> Convert it to JSON
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
		
		//Task2) Update place with new adds
		String newAddress = "Summer Walk, Africa";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Task 3) Validate address
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js2 = new JsonPath(getPlaceResponse);
		String actualAddress = js2.getString("address");
		System.out.println(actualAddress);
		
		//Assert newAddress == actualAddress by using Cucumber Jnuit or TestNG
		Assert.assertEquals(actualAddress, newAddress);
		
		
	}

}

