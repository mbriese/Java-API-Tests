# CNNAssignment
Google Civic API tests

The assignment was to investigate how to use new services. In this exercise you will be doing just that.

Using Google's Civic Information API create a test script around the Elections: electionQuery.
Google's Civic API: https://developers.google.com/civic-information
The Civic API includes details:
(1) we need an API_Key (obtained through Google Developers Console)
(2) each developers needs to manage the API through their own project;
(3) try the API in the sandbox in the Google API home (https://developers.google.com/civic-information) 
    and https://developers.google.com/civic-information/docs/v2/elections/electionQuery
(4) errors are https://developers.google.com/civic-information/docs/v2/errors

Civic API Info - electionQuery - returns a list of upcoming elections
   Test - send query with valid API_KEY - get the list of upcoming elections (validate response code);
   Test - send query with an invalid API_KEY - bad response (validate response code);
   Test - send query with valid API_KEY - get response time;
   Test - send query with valid API_KEY - get list (validate list is not empty);
   Test - send query with valid API_KEY - get list (get count of elections);
   
ElectionQuery (produces a list of elections) to be used by VoterInfo.
  Test - send query with valid API_KEY, address & electionID to test successes & error response from voterInfo query
    response code = 200 with correct electionID & demo electionID; and
    response code = 400 with invalid electionID & past electionID.
