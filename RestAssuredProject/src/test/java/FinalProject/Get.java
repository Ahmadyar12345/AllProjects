 package FinalProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Get {
	
	
	@Test
	public void get() {
		
		RestAssured
		.when()
		.get("https://reqres.in/api/users?page=246").
		then().
		assertThat().
		statusCode(200).
		log().all();
		 
	}

}
