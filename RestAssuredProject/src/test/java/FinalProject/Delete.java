package FinalProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Delete {
	
	@Test
	public void deleteUser() {
		
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "public/v2/users/246";
		RestAssured
		.when()
		.delete()
		.then()
		.statusCode(204);
			
	}

}
