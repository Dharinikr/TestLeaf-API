package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	public static void main(String[] args) {
		
		//step 1: Get end point/url for the server
		//To access method()/variable syntax is - ClassName.Method()/Variable;
		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/incident";
		
		//step 2 : Authentication
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;
		
		//RestAssured.useRelaxedHTTPSValidation();
		
		//step 3: Request type
		Response response = RestAssured.get();
		
		//to print the response/status code
	
		System.out.println(response.getStatusCode());
		
		//to print content type
		System.out.println(response.getContentType());
		
		
		//to print full response body; prettyPrint has sysout property, so no need to use sysout seperately
		//response.prettyPrint();
		
	}

}
