package salesforce;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNewContact {

	public static void main(String[] args) {
		
RestAssured.baseURI = "https://ap16.salesforce.com/services/data/v20.0/sobjects/contacts";

RestAssured.authentication = RestAssured.oauth2("00D2w00000ABvdk!AQ0AQP57qT_VldNUhaIDelgdk5WSsUvTTEcKKyY7jw9b8");


Response response =RestAssured
.given()
.contentType(ContentType.JSON)
.body("{\"FirstName\": \"sharath\",\"LastName\": \"K\", \"MobilePhone\": \"99999666\", \"Email\":\"sharath123@yahoo.com\",\"Salutation\": \"Mr\"}");
.post();

System.out.println(response.getStatusCode());		
System.out.println(response.getContentType());
		
//response.prettyPrint();
		

	}

}


/*{
    "FirstName": "lavanya",
    "LastName": "K",
    "MobilePhone": "9999999990",
    "Email": "lavanya.koonala@gmail.com",
    "Salutation": "Ms."
}*/
