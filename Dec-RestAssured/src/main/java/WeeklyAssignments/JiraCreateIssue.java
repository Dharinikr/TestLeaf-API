package WeeklyAssignments;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JiraCreateIssue {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		//
		
		//step 2 : Authentication
		
	//RestAssured.authentication = RestAssured.basic("hari.radhakrishnan@testleaf.com","0SEJo0HZ5owkxZ61tut8FA75") ;
	RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","0SEJo0HZ5owkxZ61tut8FA75");
		
	//step 3: Request type + post + body
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON) 
					.body("{\"fields\": {\"project\": {\"key\": \"RA\"},\"summary\": \"create issue in RA project\",\"description\": \"Creating of an issue using project keys and issue type names using the REST API-REST assignment\", \"issuetype\": {\"name\": \"Bug\"}}}")
					.post();
	
			//to print the response/status code
			System.out.println(response.getStatusCode());
			
			//to print content type
			System.out.println(response.getContentType());
			
			//to print full response body; prettyPrint has sysout property, so no need to use sysout seperately
			response.prettyPrint();

		}
	
	}


