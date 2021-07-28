package steps;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class IncidentManagement {
	
	public ValidatableResponse validateRes;
	
	@Given("setup the end point")
	public void setEndPoint() {
		RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/incident";
		}
	
	@And("set authentication with valid credentials")
	public void setAuthentication() {
		RestAssured.authentication = RestAssured.basic("admin","Doll1989@") ;
		}
	
	@When("user post the request")
	public void postRequest() {
		validateRes = RestAssured
				.given()
				.contentType(ContentType.JSON) 
				.post()
				.then()
				.assertThat();
	}
	
	@When("user post the request with body as (.*)$")
	public void postRequestwithBody(String filename) {
		validateRes = RestAssured
				.given()
				.contentType(ContentType.JSON) 
				.body(new File("./data/"+filename+".json"))
				.post()
				.then()
				.assertThat();
	}
	
	@Then("verify the status code as {int}")
	public void verifyStatus(int code) {
		validateRes.statusCode(code);
		
		}
	
	
	@And("verify the content type")
	public void verifyContent() {
		validateRes.contentType(ContentType.JSON);
		
		}
	

}
