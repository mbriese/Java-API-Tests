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
public class voterInfoQuery {
    /* String API and API KEY to get list of elections */
    String uri = "https://www.googleapis.com/civicinfo/v2/voterinfo?address=California&key=AIzaSyAWsQM3Rf9k2hwMl3zz4f_9N28pYODmXSM";

    String demoElectionID =  "&electionId=2000";
    String invalidElectionID = "&electionID=0000";
    String upcomingOKElectionID = "&electionID=4893";
    String upcomingALElectionID = "&electionID=4898";
    String upcomingOUTElectionID = "&electionID=4910";
    String pastElectionID = "&electionID=4889";


    /* TDD test for Google Civic API Voter Info*/
    /* Test 0 : Can I access the API response code = 200 */
    @Test
    public void testVoterInfoResponseCodeValidElectionID() {
        String api = uri+demoElectionID;
        int code = get(api).getStatusCode();
        Assert.assertEquals(code, 200);
        System.out.println("response code "+code);
    }

    /* TDD test for Google Civic API Voter Info*/
    /* Test 1 : Can I access the API response code = 400 */
    @Test
    public void testVoterInfoResponseCodeInvalidElectionID() {
        String api = uri+invalidElectionID;
        int code = get(api).getStatusCode();
        String statusMessage = get(api).statusLine();
        Assert.assertEquals(code, 400);
        System.out.println("response code "+code);
        System.out.println("status line "+statusMessage);
    }

    /* TDD test for Google Civic API Voter Info*/
    /* Test 1 : Can I access the API response code = 400 */
    @Test
    public void testVoterInfoResponseCodePastElectionID() {
        String api = uri+pastElectionID;
        int code = get(api).getStatusCode();
        String statusMessage = get(api).statusLine();
        Assert.assertEquals(code, 400);
        System.out.println("response code "+code);
        System.out.println("status line "+statusMessage);
    }



}
