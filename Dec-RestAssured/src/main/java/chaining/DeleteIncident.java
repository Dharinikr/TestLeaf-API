package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident extends BaseRequest {
	
	@Test(dependsOnMethods ="chaining.CreateIncidentWithoutBody.createIncidentWithoutBody")
	public void deleteIncidents() {
		
//	Step1: Get URl / Endpoint for the server
	RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/incident";
//	Step2: Authentication
	RestAssured.authentication = RestAssured.basic("admin","Doll1989@");
	
	//Step3: Request type
	Response response = RestAssured
			.given()
			.contentType(ContentType.JSON)
			.delete(sys_id);
			/*rather hard coding sys id , we can keep sys_id in base class and extends
			.delete("ddeff8762f952010e925bcb62799b686");*/
//	Step4: print Status code
	System.out.println(response.getStatusCode());		
//	Step5: Print ContentType
	System.out.println(response.getContentType());
//  Print Response body
	response.prettyPrint();
	
	
	
}

}
