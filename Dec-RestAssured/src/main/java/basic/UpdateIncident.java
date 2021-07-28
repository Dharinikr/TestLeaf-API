package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident {
	
@Test
	public void updateIncident() {
		
		//step 1: Get end point/url for the server
		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/";
		
		//step 2 : Authentication
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;
		
	//step 3: Request type
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
//keyname(userdefined), pathParam
				.pathParams("sysId", "d24cf0f22f952010e925bcb62799b6e2") 
				.body("{\"short_description\":\"update Incident with Rest Assured\"}")
				.put("incident/{sysId}");
		
		//to print the response/status code
		System.out.println(response.getStatusCode());
		
		//to print content type
		System.out.println(response.getContentType());
		
		//to print full response body; prettyPrint has sysout property, so no need to use sysout seperately
		response.prettyPrint();
		
	}

}
