package week4day2;

import java.util.Map;
import java.util.Map.Entry;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class cookies {
	
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
				.get()
				.then().assertThat()
				.extract().response();
		
		//to print the response/status code
	
		System.out.println(response.getStatusCode());
		
		//to print content type
		System.out.println(response.getContentType());
		
		//to print full response body; prettyPrint has sysout property, so no need to use sysout seperately
		//response.prettyPrint();
		
		Map<String, String> cookies = response.getCookies();
		
		for (Entry<String, String> eachEntry : cookies.entrySet()) {
			
			System.out.println(eachEntry.getKey() + ":"+ eachEntry.getValue());
			
			//JSESSIONID:6BC19D32C32CBA5DDE3344625315D2DA
			
		}
		
	}

}
