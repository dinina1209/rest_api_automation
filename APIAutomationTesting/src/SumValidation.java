
import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	@Test
	public void sumOfCourses() {
		JsonPath js = new JsonPath(payload.CoursePrice());
		int count = js.getInt("courses.size()");
		int sum =0;
		for(int i=0; i<count; i++) {
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			sum = sum + amount;
			System.out.println("amount" + amount);
		}
		System.out.println("sum" + sum);
		
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
	}
}
