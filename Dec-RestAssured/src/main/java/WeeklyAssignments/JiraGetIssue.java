package WeeklyAssignments;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JiraGetIssue {
	
	public static void main(String[] args) {
	
		//step 1: Get end point/url for the server
	RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/search?jql=project=RA";
	
		//step 2 : Authentication
	//RestAssured.authentication = RestAssured.basic("hari.radhakrishnan@testleaf.com","0SEJo0HZ5owkxZ61tut8FA75") ;
	RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","0SEJo0HZ5owkxZ61tut8FA75");
	
	//step 3: Request type
	Response response = RestAssured.get();
	
	//to print the response/status code
	System.out.println(response.getStatusCode());
			
    //to print content type
			System.out.println(response.getContentType());
			
			//response.prettyPrint();
			
			//need to parse as json
			JsonPath jsonResponse = response.jsonPath();
			
			//to get all ID
			List<String> listID = jsonResponse.getList("issues.id");
			System.out.println(listID);
			
			List<String> listKey = jsonResponse.getList("issues.key");
			System.out.println(listKey);
			
			for (String eachItem : listID) {
				System.out.println(eachItem);
				
			}
			
			
		}
	
	}


