 package oAuthPostman;
 
 import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SpecBuilderTest {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";	
		
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
		ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification res = given().spec(req).body(place);
		
		Response response = res.when().post("/maps/api/place/add/json")
		.then().spec(resSpec).extract().response();
		
		String responseStrings = response.asString();
		System.out.println("responseStrings" + responseStrings);
	}
}
