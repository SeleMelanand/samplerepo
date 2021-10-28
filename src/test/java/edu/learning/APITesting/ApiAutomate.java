package edu.learning.APITesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ApiAutomate {
	String placeId;
	
	@Test(priority=1)
	public void addPlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(BaseClass.addPlace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
		
		System.out.println(response);
		JsonPath jspath = new JsonPath(response); //Parsing the response string in to JSON
		placeId = jspath.get("place_id");
		
		System.out.println("from response :: "+ placeId);
		
		getPlace();
		
		
		String updatedResponse = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(BaseClass.updatePlace())
		.when().put("maps/api/place/update/json")
		.then().extract().response().asString();
		
		System.out.println("Deatils after update is executed************");
		
		getPlace();
	}
	
	//@Test(priority=2)
	public void getPlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String getResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().extract().response().asString();

		System.out.println(getResponse);
		
		JsonPath getResponsejspath = new JsonPath(getResponse); //Parsing the response string in to JSON
		String addressRetrieved = getResponsejspath.get("address");
		
		System.out.println("addressRetrieved is :::"+ addressRetrieved);

	}
}
