package demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class BugTest {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://ahyeonna1209.atlassian.net/";
		String createIssueResponse =	given()
			.header("Content-Type", "application/json")
			.header("Authorization","Basic YWh5ZW9uLm5hMTIwOUBnbWFpbC5jb206QVRBVFQzeEZmR0YwekNvMXNLc2RkeVFESXFsb3MtRHBITXREdUZaMzJoeHZNdXRMMzltbnRUSms4dmVMbmNlVWtNNS0xMWxxRy1yVTg4a25fNm0wck5YSTE0Wlh4MEdoSUtRLWpGOVE0V2lvRUozS2VhV0txaFpGdVZSbThhN2JTTGxSQm1iSTBfeUpmUFN3dG5TVXdBakhSdzBfLVBDYnJkaHp0cjU2QWw3eTlqUHlMWHBEYjZzPUExRUZFQjA5")
			.body("{\r\n"
					+ "    \"fields\": {\r\n"
					+ "       \"project\":\r\n"
					+ "       {\r\n"
					+ "          \"key\": \"SCRUM\"\r\n"
					+ "       },\r\n"
					+ "       \"summary\": \"button is not working - automation\",\r\n"
					+ "       \"description\": \"button is not working\",\r\n"
					+ "       \"issuetype\": {\r\n"
					+ "          \"name\": \"Bug\"\r\n"
					+ "       }\r\n"
					+ "   }\r\n"
					+ "}")
			.log().all()
			.post("rest/api/2/issue").then().log().all()
			.assertThat().statusCode(201)
			.extract().response().asString();
		
			JsonPath js = new JsonPath(createIssueResponse);
			
			String issueId = js.getString("id");
			System.out.println("issueId"+ issueId);
			
			//Add Attachment
			given()
			.pathParam("key", issueId)
			.header("X-Atlassian-Token", "no-check")
			.header("Authorization","Basic YWh5ZW9uLm5hMTIwOUBnbWFpbC5jb206QVRBVFQzeEZmR0YwekNvMXNLc2RkeVFESXFsb3MtRHBITXREdUZaMzJoeHZNdXRMMzltbnRUSms4dmVMbmNlVWtNNS0xMWxxRy1yVTg4a25fNm0wck5YSTE0Wlh4MEdoSUtRLWpGOVE0V2lvRUozS2VhV0txaFpGdVZSbThhN2JTTGxSQm1iSTBfeUpmUFN3dG5TVXdBakhSdzBfLVBDYnJkaHp0cjU2QWw3eTlqUHlMWHBEYjZzPUExRUZFQjA5")
			//attach file of the path
			.multiPart("file", new File("C://Users/dna975/Downloads/image.png")).log().all()
			.post("rest/api/3/issue/{key}/attachments")
			.then().log().all().assertThat().statusCode(200);

			
		}
}
