$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/get.feature");
formatter.feature({
  "name": "To fetch the student details with courseID",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "Getting student details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "I want to get list of students",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.E2E.i_want_to_get_list_of_students()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Student details are displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.E2E.student_details_are_displayed()"
});
formatter.result({
  "status": "passed"
});
});