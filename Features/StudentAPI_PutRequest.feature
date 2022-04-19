Feature: PUT: Automated Students Tests
  Description: PUT: The purpose of this feature is to test some demo app.

  @put
  Scenario Outline: PUT: Test the Students app
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"


    Examples:
      | TestName  | URL          | ContentType      | RequestBody         | RequestMethod | StatusCode |
      | TestPut-005 |  /updateStudent| application/json | testdata/test-put.json | PUT           |        200 |

  @putfail
  Scenario Outline: PUT: Test the Demo app
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"


    Examples:
      | TestName  | URL          | ContentType      | RequestBody         | RequestMethod | StatusCode |
      | TestPutFail-006 | /updateStudent | application/json | testdata/test-putfail.json | PUT           |        404 |
