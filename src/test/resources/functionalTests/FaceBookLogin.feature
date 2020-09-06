@FB
Feature: check facebook login functionality
We are checking login functionality

Scenario: Successful Login with Valid Credentials
	Given User Navigate to facebook LogIn Page 
   When User enters details "<UserName>" and "<Password>" on facebookPage
   Then homepage is displayed Login Successfully for facebook
   
   