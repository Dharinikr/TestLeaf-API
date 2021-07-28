package salesforce;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllSalesforce {

	public static void main(String[] args) {
		
RestAssured.baseURI = "https://ap16.salesforce.com/services/data/v20.0/sobjects";
		//RestAssured.baseURI = "https://ap16.salesforce.com/services/data";
		
//RestAssured.authentication = RestAssured.oauth2("00D2w00000ABvdk!AQ0AQP57qT_VldNUhaIDelgdk5WSsUvTTEcKKyY7jw9b8","URlJduM3wGQ2dh5mzTHlcjit2petzN_tFGzMCcVOVfJILXcYyq0");

RestAssured.authentication = RestAssured.oauth2("00D2w00000ABvdk!AQ0AQP57qT_VldNUhaIDelgdk5WSsUvTTEcKKyY7jw9b8URlJduM3wGQ2dh5mzTHlcjit2petzN_tFGzMCcVOVfJILXcYyq0");

Response response = RestAssured.get();
		
System.out.println(response.getStatusCode());		
System.out.println(response.getContentType());
		
response.prettyPrint();
		

	}

}
