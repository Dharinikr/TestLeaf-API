package parameters;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FormParameter {
	
	@Test
	public void loginLeaftaps() {
		
		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "http://leaftaps.com/opentaps/control/login";
		RestAssured.urlEncodingEnabled = false;
		// Step 2: Request type - Post + form param
		Response post = RestAssured
			.given()
//			.contentType(ContentType.URLENC)
			.when()  //It is an optional .when() just used for readability. after this we give some request
			.formParam("USERNAME", "DemoCSR2")
			.formParam("PASSWORD", "crmsfa")
			.post();
			
		post.prettyPrint();
		
	}

}
