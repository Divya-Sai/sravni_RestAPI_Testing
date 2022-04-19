package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.logging.Logger;
import com.cucumber.listener.Reporter;


public class steps {

    public static String apiEndPointUri;
    public static String CONTENT_TYPE;
    public static String STATUS_CODE;
    public static String FILE_PATH;
    public static String REQUESTBODY;
    public static Response response;
    public static String RESPONSEBODY;

    @Given("I want to set URL as {string} for test case {string}")
    public void i_want_to_set_URL_as_for_test_case(String url, String testCaseName) {

        String apiHostName = "http://localhost:8080";
        apiEndPointUri = String.format("%s%s", apiHostName, url);
    }

    @When("I set header content type as {string}")
    public void i_set_header_content_type_as(String contentType) {

        if (contentType != null && !contentType.isEmpty()) {
            CONTENT_TYPE = contentType;
        }
    }

    @When("I hit the API with requestbody {string} and request method is {string}")
    public void submitRequest(String requestBodyPath, String requestType) {

        RestAssured.baseURI = apiEndPointUri;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", CONTENT_TYPE);
        if (requestBodyPath != null && !requestBodyPath.isEmpty() && requestType.equalsIgnoreCase("POST")
                || requestType.equalsIgnoreCase("PUT")) {
            JSONParser jsonParser = new JSONParser();
            FILE_PATH = System.getProperty("user.dir") + "//src//test//java//"
                    + requestBodyPath;
           // logger.info("Path of requestbody file is :: " + FILE_PATH);
            try (FileReader reader = new FileReader(FILE_PATH)) {
                Object obj = jsonParser.parse(reader);
                REQUESTBODY = obj.toString();
                //logger.info("Request Body is :: " + REQUESTBODY);
            } catch (FileNotFoundException | ParseException exc) {
                exc.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (REQUESTBODY.length() > 0) {
                request.body(REQUESTBODY);
                response = request.post();
            } /*else {
                Reporter.addStepLog(Status.FAIL + " :: Request Body cannot be null or empty!");
              //  logger.info(" Request Body cannot be null or empty!");
            }*/
        } else if (requestType.equalsIgnoreCase("GET")) {
            response = request.get();
        }
        STATUS_CODE = String.valueOf(response.getStatusCode());
        RESPONSEBODY = response.getBody().asString();
       // Reporter.addStepLog(Status.PASS + " :: Request successfully processed");
       // Reporter.addStepLog("Response is :: " + RESPONSEBODY);

    }


    @Then("I try to verify the status code is {string}")
    public void i_try_to_verify_the_status_code_is(String statusCode) {

        if (statusCode.equals(String.valueOf(STATUS_CODE))) {
            Assert.assertEquals(STATUS_CODE, statusCode);
        }
        else {
            Assert.assertEquals(STATUS_CODE, statusCode);
        }
    }

    @Then("I try to verify the response value {string} is {string}")
    public void verifyResponseValue(String responseKey, String value) throws ParseException {

        Object obj = responseKey;
        JSONParser parser = new JSONParser();
        JSONObject responseObject = (JSONObject) parser.parse(RESPONSEBODY);
        Object key = (Object) responseObject.get(responseKey);
        compareResponseValues(String.valueOf(value), String.valueOf(key), responseKey);
    }

    private void compareResponseValues(String expected, String actual, String responseKey) {
      //  Reporter.addStepLog("Actual Value is  ::" + actual);
      //  Reporter.addStepLog("Expected Value is  ::" + expected);
        //logger.info("Actual Value is  ::" + actual);
        //logger.info("Expected Value is  ::" + expected);
        if (expected.equals(actual)) {
            Assert.assertEquals(actual, expected);
           // Reporter.addStepLog(Status.PASS + " " + responseKey + " : Expected value : " + expected
                  //  + " mathches with Actual Value : " + actual);
        } else {
           // Reporter.addStepLog(Status.FAIL + " " + responseKey + " : Expected value : " + expected
                  //  + " do not matches with Actual Value : " + actual);
            Assert.assertEquals(actual, expected);
        }
    }





}
