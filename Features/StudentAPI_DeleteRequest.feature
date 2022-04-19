Feature: Delete: Automated Students Tests
  Description: PUT: The purpose of this feature is to test some demo app.

  @Del
  Scenario Outline: Delete: Test the Students app
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"


    Examples:
      | TestName  | URL          | ContentType      | RequestBody         | RequestMethod | StatusCode |
      | TestDelete-007 |  /deleteStudent| application/json | testdata/test-del.json | DELETE           |        200 |

  @putfail
  Scenario Outline: PUT: Test the Demo app
    Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    Then I try to verify the status code is "<StatusCode>"


    Examples:
      | TestName  | URL          | ContentType      | RequestBody         | RequestMethod | StatusCode |
      | TestDeleteFail-008 | /deleteStudent | application/json | testdata/test-Delfail.json | DELETE           |        200 |
