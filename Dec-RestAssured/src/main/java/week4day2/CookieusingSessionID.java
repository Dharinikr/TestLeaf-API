package week4day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CookieusingSessionID {
	public static void main(String[] args) {

	RestAssured.baseURI = "https://dev86889.service-now.com/api/now/table/incident";
	
	Response response = RestAssured
			.given()
			.cookie("JSESSIONID", "B246B1245DD224A83610FD92C0E84B4A") // sessionID expires very quickly. In that case get another SessionID and try
			.get()
			.then().assertThat()
			.extract().response();
	
	System.out.println(response.getStatusCode());	
	
	System.out.println(response.getContentType());
}
}
