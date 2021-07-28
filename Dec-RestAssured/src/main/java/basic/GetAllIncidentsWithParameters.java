package basic;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidentsWithParameters {
	
	public static void main(String[] args) {
		
		//step 1: Get end point/url for the server
		//To access method()/variable syntax is - ClassName.Method()/Variable;
		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/incident";
		
		//step 2 : Authentication
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;
		
		//step 3: Request type and Query parameter
	Response response = RestAssured
	.given()
//	.queryParam("sysparm_fields", "number,short_description,sys_id")
//	.queryParam("sysparm_limit", "20")
	.get();
		
		//to print the response/status code
		System.out.println(response.getStatusCode());
		
		//to print content type
		System.out.println(response.getContentType());
		
		//to print response body
		//response.prettyPrint();
		
		//to filter the response we can use query parameter in the request field or we can parse the response and request the required field
		//the other way of getting the required feild from response..
		//need to parse as json, if we need response in json format
		JsonPath jsonResponse = response.jsonPath();
		
		//if we want to parse response in other format like xml , html...
		//response.xmlPath(); response.htmlPath();
		
		
		
		
		//get one incident number
		//System.out.println(jsonResponse.get("result[1].number")); //--> to get only one first matching incident number
		
		//this is to get all number
		List<String> list = jsonResponse.getList("result.number");
		System.out.println(list);
		
		for (String eachItem : list) {
			System.out.println(eachItem);
			
		}
		
	}

}
