package parameters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RequestParameters {
	
	@Test
	public void requestParams() {

		// Step 1: Get the URL / Endpoint for the services		
		RestAssured.baseURI = "https://dev49243.service-now.com/api/now/table/incident";

		// Step 2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");

		// Add the parameters
		Map<String, String> parametersMap = new HashMap<String, String>();
		parametersMap.put("category", "software");
		parametersMap.put("sysparm_fields", "number, sys_id");

		// Step 3: Request type - Get + query param -> Response
		Response response = RestAssured
				.given()
//				.param("key", "value")
				.params(parametersMap)
				.post();

		// Step 4: Validate (Response -> Status Code : 200)
		System.out.println(response.getStatusCode());

		// Print the response time as well
		System.out.println(response.getTime());

		// Check what is the response format
		System.out.println(response.getContentType());

		// print the response
		response.prettyPrint();

		// Need to parse JSON
		JsonPath jsonResponse = response.jsonPath();

		// Get the incident.numbers
		List<String> listOfNumbers = jsonResponse.getList("result.number");

		// How to count of numbers?
		System.out.println(listOfNumbers.size());




	}


}
