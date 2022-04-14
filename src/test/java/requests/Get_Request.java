package requests;

import org.junit.jupiter.api.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Get_Request {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://bookstore.toolsqa.com";
		
		//RestAssured.baseURI = "http://localhost:8080";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/Bookstore/v1/Books");
		
		//Response response = httpRequest.request(Method.GET,"getStudentsByCourseId");
		int statuscode = response.getStatusCode();
		System.out.println("Response of status code is "+statuscode);
		
		Assertions.assertEquals(200, statuscode);
		
		
		Headers header = response.getHeaders();
		//System.out.println("Headers for the response are "+header);
		int countofheaders = header.asList().size();
		Assertions.assertEquals(7, countofheaders);
		String headerValue = response.getHeader("Content-Type");
		Assertions.assertEquals("application/json; charset=utf-8", headerValue);
		
		
		String responsebodystring = response.getBody().asString();
		Assertions.assertTrue(responsebodystring.contains("Git Pocket Guide"));
		
		
		JsonPath jsonpathevaluator = response.jsonPath();
		
		String data = jsonpathevaluator.get("/Book");
		System.out.println(data);
		
		ResponseBody body = response.getBody();
		//body.prettyPrint();
		System.out.println("Response Body is "+body.asString());
		

	}

}
