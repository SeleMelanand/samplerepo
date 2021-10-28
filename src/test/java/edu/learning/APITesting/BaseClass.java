package edu.learning.APITesting;

public class BaseClass {
	
	public static String addPlace() {
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"200, MainStreet, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String updatePlace() {
		
		return "{\r\n"
				+ "\"place_id\":\"e5bfb5aa44fb5725d0151c30a1ccfb60\",\r\n"
				+ "\"address\":\"1234 Main Street, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
		
	}

}
