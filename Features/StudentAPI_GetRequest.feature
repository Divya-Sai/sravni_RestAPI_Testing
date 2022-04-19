Feature: GET: Automated Student API Tests


  Scenario Outline: GET: Test the Student API app
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"

    Examples:
      | TestName  | URL               | ContentType      | RequestBody | RequestMethod | StatusCode |
      | TestGet001 | /getStudentsByCourseId/c_1| application/json |             | GET           |        200 |


  Scenario Outline: GET: Test the Demo app
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"

    Examples:
      | TestName  | URL               | ContentType      | RequestBody | RequestMethod | StatusCode |
      | TestGetFail002 | /getStudentsByCourseId/001 | application/json |             | GET           |        200 |