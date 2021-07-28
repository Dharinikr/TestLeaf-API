package basic;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentwithBodyAsJsonMultipledata {

	@DataProvider(name = "fetchData")
	public String[] getData() {
		//String[] --> file path
		String[] allFile = new String[2];
		allFile[0] = "./data/incident1.json";
		allFile[1] = "./data/incident2.json";
		return allFile;
	
	}
	
	
	@Test(dataProvider = "fetchData")
	public void createIncidentWithJsonFile(String filePath) {

		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;
		
		//step 3: Request type + post + body
		
		File file = new File(filePath);
		
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
