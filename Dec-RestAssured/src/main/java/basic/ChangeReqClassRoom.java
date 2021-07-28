package basic;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ChangeReqClassRoom {
	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/change_request";
		
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@");
		
		Response response = RestAssured
				.given()
				.get();
		
		//to print the response/status code
				System.out.println(response.getStatusCode());
				
				//to print content type
				System.out.println(response.getContentType());
				
				//need to parse as json
				JsonPath jsonResponse = response.jsonPath();
				
				//this is to get all number
				List<String> list = jsonResponse.getList("result.sys_id");
				System.out.println(list);
				
				for (String eachItem : list) {
					System.out.println(eachItem);
					
				}
		
	}
	

}

/*RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/change_request";

RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;

Response response = RestAssured
		.given()
		.queryParam("sysparm_fields", "type,short_description,sys_id")
		.queryParam("sysparm_limit", "20")
		.get();

response.prettyPrint();*/
