package stepDefinition;

import org.junit.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class E2E {

	private static final String BASE_URL  = "http://localhost:8080";
	
	private static Response response;
	@Given("I want to get list of students$")
	public void i_want_to_get_list_of_students() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		response = request.request(Method.GET,"/getStudentsByCourseId/c_1");
		
//Response response = httpRequest.request(Method.GET,"/Bookstore/v1/Books");
		
		//Response response = httpRequest.request(Method.GET,"/getStudentsByCourseId");
		int statuscode = response.getStatusCode();
		System.out.println("Response of status code is "+statuscode);
		

		String jsonString = response.asString();
		
		
	}
	
	
	
	@Then("^Student details are displayed$")
	public void student_details_are_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(200, response.getStatusCode());
	}


	
	
}
