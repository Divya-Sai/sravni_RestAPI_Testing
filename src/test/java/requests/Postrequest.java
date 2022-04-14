package requests;



import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postrequest {

	
	@Test
	public void createUserTest() {
		
		
		RestAssured.baseURI = "http://bookstore.toolsqa.com";
		
		String payload = "{\r\n"
				+ "  \"userName\": \"mndmfndmbcvncv\"\r\n"
				+ "  \"password\": \"Ndsmdnsd@1232\"\r\n"
				+ "}";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type","application/json;charset=utf-8");
		Response response = httpRequest.body(payload).post("/Account/v1/User");
		int statuscode = response.getStatusCode();
		System.out.println("Response status code is "+statuscode);
		
		
		
		
		
	}
	


}
