import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(payload.CoursePrice());
		
		//Print number of course from API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//Print purchase amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		//Print title of the first course
		String titleFirstCourse = js.getString("courses[0].title");
		System.out.println(titleFirstCourse);
		
		//Print All courses titles and their respective Prices
		for(int i=0;i<count;i++) {
			String courseTitles = js.get("courses["+i+"].title");
			System.out.println(courseTitles);
			System.out.println(js.get("courses["+i+"].price").toString());
		}
		//Print number of copies sold by RPA Course
		for(int i=0; i<count; i++) {
			String courseTitles = js.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA")) {
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}
		}
		
		//Verify if Sum of all Courses prices matches with Purchase Amount
		

	}

}
