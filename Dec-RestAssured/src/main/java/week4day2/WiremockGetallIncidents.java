package week4day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WiremockGetallIncidents {

	// this is without giving stub.. and also for recording
	public static void main(String[] args) {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@");
		Response response = RestAssured
				.given()
				.queryParam("sysparm_limit", "1")
				.get()
				.then().assertThat()
				.extract().response();
		System.out.println(response.getStatusCode());		
		System.out.println(response.getContentType());
		response.prettyPrint();

	}

}
