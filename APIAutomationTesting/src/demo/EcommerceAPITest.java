package demo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;
import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;

public class EcommerceAPITest {
	public static void main(String[] args) {
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.setContentType(ContentType.JSON).build();
		
		//Login
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail("diny1209@naver.com");
		loginRequest.setUserPassword("Nabi1209!");
		
		RequestSpecification reqLogin = given().log().all().spec(req).body(loginRequest);
		LoginResponse loginResponse = reqLogin.when().post("api/ecom/auth/login")
		.then().extract().response().as(LoginResponse.class);
		System.out.println("token"+ loginResponse.getToken());
	}
}
