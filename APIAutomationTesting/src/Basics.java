import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.payload;

public class Basics {

	public static void main(String[] args) {
		//Validate if Add Place API is working as expected
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		// Given - All input details - POST call
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(payload.AddPlace())
		// When - Submit the API - resource, http method
		.when().post("maps/api/place/add/json")
		// Then - Validate the response
		.then().log().all().assertThat()
		.statusCode(200)
		//validate if body includes key(scope) and value(APP)
		.body("scope", equalTo("APP"))
		//validate if Header includes key(Server) and value(Apache/2.4.52 (Ubuntu))
		.header("Server", "Apache/2.4.52 (Ubuntu)");
		
		//Task : Add place -> update place with new adds -> Get place to validate if new adds is added
	}

}

