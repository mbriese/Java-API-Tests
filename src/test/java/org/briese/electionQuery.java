package org.briese;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.parsing.Parser;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class electionQuery {
    /* String API and API KEY to get list of elections */
    String uri = "https://www.googleapis.com/civicinfo/v2/elections";
    String API_KEY = "?key=AIzaSyAWsQM3Rf9k2hwMl3zz4f_9N28pYODmXSM";
    String INVALID_API_KEY = "?key=AIzaSyAWsQM3Rf9k2hwMl3zz4f_";

    String api = uri + API_KEY;
    String invAPI = uri + INVALID_API_KEY;

    String header = "https://www.googleapis.com/civicinfo/v2/elections?key=AIzaSyAWsQM3Rf9k2hwMl3zz4f_9N28pYODmXSM";

    /* TDD test for Google Civic API */
    /* Test 0 : Can I access the API response code = 200 */
    @Test
   public void testAuthorizedResponse() {
        int code = get(api).getStatusCode();
        Assert.assertEquals(code, 200);
        System.out.println("response code "+code);
    }

    /* Test 1: Unauthorized request response code = 400 */
    /* according to the specifications
       unauthorized	401
       The request was not appropriately authorized. */
    /* expected pass - but fails */
    @Test
    public void testUnauthorizedRequest() {
        int code = get(invAPI).getStatusCode();
        Assert.assertEquals(code, 400);
        System.out.println("response code "+code);
    }

    /* Test 2: Response time < timeLimit */
    /*       : response time = -1 means no response */
    @Test
    public void responseTimeLessThan60Seconds(){
        long responseTime = get(api).getTime();
        boolean responseReceived = (responseTime != -1);
        Assert.assertTrue(responseReceived);
        System.out.println("Response time received");
        /* responseTime is less than 10 sec */
        boolean actualResponseWithinRange = (responseTime < 10000);
        Assert.assertTrue(actualResponseWithinRange);
        System.out.println("response time is "+responseTime);
    }

    /* Test 3: is election list empty? */
    /* response usually has a Test Election          */
    /* {"kind": "civicinfo#electionsQueryResponse",
            "elections": [
            { "id": "2000",
              "name": "VIP Test Election",
              "electionDay": "2021-06-06",
              "ocdDivisionId": "ocd-division/country:us"},]} */
    @Test
    public void getElectionsNotAnEmptyList(){
       RestAssured.baseURI = header;
       RequestSpecification httpRequest = RestAssured.given();
       Response response = httpRequest.request(Method.GET, header );
       String responseBody = response.getBody().asString();

       System.out.println(responseBody);
    }


    /* Test 4: does election list contain multiple electionID? */


}
