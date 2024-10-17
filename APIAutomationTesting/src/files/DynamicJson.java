package files;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class DynamicJson {
	
	//connect addBook data by using 'dataProvider'
	@Test(dataProvider = "BooksData")
	public void addBook() {
		RestAssured.baseURI ="http://216.10.245.166";
		
		String response = given().header("Content-Type", "application/json")
		.body(payload.AddBook("asd", "12334"))
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		System.out.println("response"+ response);
		
		JsonPath js = ReusableMethods.rawToJson(response);
		String id = js.getString("ID");
		System.out.println("id"+id);	
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		// array = collection of elements
		// multi-diemnsional array = collection of arrays
		
		//isbn, aisle
		return new Object[][]{{"ojfwty", "1232"}, {"wdfe", "9374"}, {"idkw", "8463"}};
	}
	
}
