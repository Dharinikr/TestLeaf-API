package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident {
	
	@Test
	public void deleteIncident() {
		
		//step 1: Get end point/url for the server
		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/";
		
		//step 2 : Authentication
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;
		
	//step 3: Request type
		Response response = RestAssured
				.given()
				//			keyname(userdefined), pathParam (to get sys_id, create an incident and get)
				.pathParam("sysId", "f69a34722f952010e925bcb62799b6cf")
				.delete("incident/{sysId}");
		
		//to print the response/status code
		System.out.println(response.getStatusCode());
		
		//to print content type
		System.out.println(response.getContentType());
		
		//to print full response body; prettyPrint has sysout property, so no need to use sysout seperately
		response.prettyPrint();
		
	}

}
