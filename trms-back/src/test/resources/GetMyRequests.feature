Feature: Logged In Employee can view His/Her Submitted Requests

  Scenario: Logged In Employee can view His/Her Submitted Requests Successfully
    Given The Employee is Logged In <emp>
    And The Employee has existing requests <req>
    When The Employee clicks on the link "My Submitted Requests"
    And The page loads
    Then The Employees requests are displayed <status>
    
        Examples: 
      | emp  | req  | status  |
      | emp1 | req1 | success |
      | emp1 | req2 | success |
      | emp2 |      | Fail    |
      | emp2 |      | Fail    |
    

  Scenario: Logged In Employee cannot view His/Her Submitted Requests Successfully
    Given The Employee is Logged In <emp>
    And The Employee does not have existing requests <req>
    When The Employee clicks on the link "My Submitted Requests"
    And The page loads
    Then No requests are displayed <status>

    Examples: 
      | emp  | req  | status  |
      | emp1 | req1 | success |
      | emp1 | req2 | success |
      | emp2 |      | Fail    |
      | emp2 |      | Fail    |
