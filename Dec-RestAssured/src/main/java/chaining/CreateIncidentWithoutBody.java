package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithoutBody extends BaseRequest {

	@Test
	public void createIncidentWithoutBody() {
	
//		Step1: Get URl / Endpoint for the server
		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/incident";
//		Step2: Authentication
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@");
//		Step3: Request type 
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
//		Step4: print Status code
		System.out.println(response.getStatusCode());		
//		Step5: Print ContentType
		System.out.println(response.getContentType());
//      Print Response body
//		response.prettyPrint();
		
		JsonPath jsonResponse = response.jsonPath();
		
		sys_id = jsonResponse.get("result.sys_id");
		
		System.out.println(sys_id);
		
		
	}
	
}
