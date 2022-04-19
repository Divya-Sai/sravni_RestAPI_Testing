Feature: POST: Automated Student API Tests

  @post
  Scenario Outline: POST: Test the Student app
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"
    And I try to verify the response value "firstName" is ""
    And I try to verify the response value "lastName" is "Bugatha"

    Examples:
      | TestName  | URL        | ContentType      | RequestBody        | RequestMethod | StatusCode |
      | TestPost_003 |/addStudent | application/json | testdata/test-post.json | POST          |        200 |

  @postfail
  Scenario Outline: POST: Test the Demo app
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"


    Examples:
      | TestName  | URL        | ContentType      | RequestBody        | RequestMethod | StatusCode |
      | TestPostFail-004 | /addStudent | application/json |  testdata/test-postfail.json | POST          |        400 |