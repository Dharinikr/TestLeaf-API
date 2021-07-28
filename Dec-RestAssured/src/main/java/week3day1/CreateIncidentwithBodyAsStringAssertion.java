package week3day1;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentwithBodyAsStringAssertion {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;
		
		//step 3: Request type + post + body
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON) 
				.body("{\"short_description\":\"create incident with body using REST Assured\",\"category\":\"Software\",\"state\":\"2\"}")
				.post()
				.then()
				.assertThat()
				//.body(path of the key,condition)
				.body("result.short_description" , Matchers.equalTo("create incident with body using REST Assured"))//equalsTo - for exact match, containsString - for partial match
				//.body("result.short_description" , Matchers.containsString("REST Assured"))//equalsTo - for exact match, containsString - for partial match
				.extract().response();
		
		
		
		//JsonPath jsonResponse = response.jsonPath();
		//to print the response/status code
		System.out.println(response.getStatusCode());
		
		//to print content type
		System.out.println(response.getContentType());
		
		//to print full response body; prettyPrint has sysout property, so no need to use sysout seperately
		response.prettyPrint();

	}

}
