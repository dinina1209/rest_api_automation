package files;

public class payload {
	// if you make it as static, you can directly by using "className.methodName" 
	// if you don't make it static, you need to create Object from this class and call Object
	public static String AddPlace() {
		return "{\r\n"
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
				+ "";
	}
	
	public static String CoursePrice() {
		return "{\r\n"
				+ "    \"dashboard\": {\r\n"
				+ "        \"purchaseAmount\" : 910,\r\n"
				+ "        \"website\" : \"rahulshettyacademy.com\"\r\n"
				+ "    },\r\n"
				+ "    \"courses\" :[\r\n"
				+ "        {\r\n"
				+ "            \"title\" : \"Selenium\",\r\n"
				+ "            \"price\" : 50,\r\n"
				+ "            \"copies\" :6\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"title\" : \"Cypress\",\r\n"
				+ "            \"price\" : 40,\r\n"
				+ "            \"copies\" :4\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"title\" : \"RPA\",\r\n"
				+ "            \"price\" : 45,\r\n"
				+ "            \"copies\" :10\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}";
	}
}
