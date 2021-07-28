package week4day2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class WiremockCreateIncident{
	
	@BeforeMethod
	public void mockPost() {
		stubFor(post("/api/now/table/incident")
		.willReturn(aResponse()
		.withStatus(201)
		.withHeader("content-type" , "application/json")
		.withBody("{\"Company Name\":\"TestLeaf\"}")));
	}
	
	
@Test
	public void createIncident() {
//RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
	RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;
		
	
		Response response = RestAssured
				.given()
				.log().all()
				.contentType(ContentType.JSON) 
				.post();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
		response.prettyPrint();

	}

	}


