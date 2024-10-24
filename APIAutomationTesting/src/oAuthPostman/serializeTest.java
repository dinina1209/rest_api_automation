 package oAuthPostman;
 
 import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class serializeTest {
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
		
		Response res = given().queryParams("key", "qaclick123")
		.body(place)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		
		String responseStrings = res.asString();
		System.out.println("responseStrings" + responseStrings);
	}
}
