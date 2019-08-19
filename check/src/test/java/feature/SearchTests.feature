Feature: Check if email id has been Pwned or not
  
Scenario: User can check if any string/email id has been Pwned or not
Given User is on the HIBP home page
When User types a "test@something.com" into the search field
And User clicks on the pwned? button to search
Then message appears saying account is pwned or not



