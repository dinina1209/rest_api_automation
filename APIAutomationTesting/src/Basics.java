import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

	public static void main(String[] args) {
		//Validate if Add Place API is working as expected
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		// Given - All input details - POST call
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"https://rahulshettyacademy.com  \",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "")
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
