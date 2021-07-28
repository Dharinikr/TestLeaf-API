package basic;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidentsWithXMLresponse {
	
	public static void main(String[] args) {
		
		//step 1: Get end point/url for the server
		//To access method()/variable syntax is - ClassName.Method()/Variable;
		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/incident";
		
		//step 2 : Authentication
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;
		
		//step 3: Request type and Query parameter + headers Accept key for XML 
	Response response = RestAssured
	.given()
	.queryParam("sysparm_fields", "number,short_description,sys_id")
	.queryParam("sysparm_limit", "20")
	.accept("application/xml") //.accept(ContentType.XML)
	.get();
		
		//to print the response/status code
		System.out.println(response.getStatusCode());
		
		//to print content type
		System.out.println(response.getContentType());
		
		//to print response body
		//response.prettyPrint();
		
		//need to parse as xml
		XmlPath xmlPath = response.xmlPath();
		
		
		//this is to get all sys_id
		List<String> list = xmlPath.getList("response.result.sys_id");
		System.out.println(list);
		
		for (String eachItem : list) {
			System.out.println(eachItem);
			
		}
		
	}

}
