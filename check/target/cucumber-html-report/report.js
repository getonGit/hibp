$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/feature/SearchTests.feature");
formatter.feature({
  "name": "Check if email id has been Pwned or not",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User can check if any string/email id has been Pwned or not",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is on the HIBP home page",
  "keyword": "Given "
});
formatter.match({
  "location": "PwnedCheck.user_is_on_the_HIBP_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User types a \"test@something.com\" into the search field",
  "keyword": "When "
});
formatter.match({
  "location": "PwnedCheck.user_types_a_email_id_into_the_search_field(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the pwned? button to search",
  "keyword": "And "
});
formatter.match({
  "location": "PwnedCheck.user_clicks_the_Enter_key_on_the_keyboard()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "message appears saying account is pwned or not",
  "keyword": "Then "
});
formatter.match({
  "location": "PwnedCheck.user_is_able_to_see_the_message_Oh_no_pwned()"
});
formatter.result({
  "status": "passed"
});
});