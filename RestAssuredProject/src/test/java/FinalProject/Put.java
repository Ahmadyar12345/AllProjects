package FinalProject;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Put {

	HashMap<String, String> map = new HashMap<>();

	@BeforeMethod
	public void createPayload() {
		map.put("name", "Amanulla");
		map.put("email", "aman123@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users/246";
	}
	@Test
	public void createResource() {
		RestAssured.given().contentType("application/json")
		.body(map).when().post().then().statusCode(201).log().all();
	}
}
