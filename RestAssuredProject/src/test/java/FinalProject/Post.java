package FinalProject;

import java.util.HashMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
public class Post {
	HashMap<String, String> map = new HashMap<>();
	
	@BeforeMethod
	public void createPayload1() {
		map.put("name", "Ahmad");
		map.put("email", "ahmad001122@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users";
	}
	
	@Test
	public void createResouce() {
		RestAssured
		.given()
		.contentType("application/json")
		.body(map)
		.when()
		.post("/api/resource")
		.then()
		.statusCode(201)
		.log()
		.all();
		
	
	
	
	
	}

}
