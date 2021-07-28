package basic;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentwithBodyAsJsonFile {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;
		
		//step 3: Request type + post + body as file
		//File file = new File("./FilePostman.json"); -- if we have file in the same project and not in any folder
		File file = new File("./data/Incident1.json");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON) 
				.body(file)
				.post();
		
		//to print the response/status code
		System.out.println(response.getStatusCode());
		
		//to print content type
		System.out.println(response.getContentType());
		
		//to print full response body; prettyPrint has sysout property, so no need to use sysout seperately
		response.prettyPrint();

	}

}
