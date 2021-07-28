package week3day1;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidentsAssertion {
	
	public static void main(String[] args) {
		
		//step 1: Get end point/url for the server
		//To access method()/variable syntax is - ClassName.Method()/Variable;
		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/incident";
		
		//step 2 : Authentication
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;
		
		//RestAssured.useRelaxedHTTPSValidation();
		//step 3: Request type
		Response response = RestAssured
				.given()
				.queryParam("sysparam_limit", "2")
				.get()
				.then()
				.assertThat()
				//.body("result.number[1]",Matchers.equalTo("INC0009002")) [we can put result.number[1] or result[1].number]
				.body("result.number",Matchers.hasItem("INC0009002"))
				//Matchers.hasItem() is for arrays-if there are many items/list to check then we use Matchers.hasItem 
				.statusCode(200)
				.extract().response();
		
		//to print the response/status code
		System.out.println(response.getStatusCode());
		
		//to print content type
		System.out.println(response.getContentType());
		
		//to print full response body; prettyPrint has sysout property, so no need to use sysout seperately
		//response.prettyPrint();
		
	}

}
