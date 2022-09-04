Feature: Get Post And Delete employees by api

  @GetEmployees
  Scenario Outline: As a user, I want consult the employees through services to carry out this process more quickly
    Given I make the connection to the api "<Uri>" with resource api "<ResourceApi>"
    When execute the method "<RequestType>"
    Then I see that the state is returned "<StatusCode>"
    And I check if the user "<Employee>" exists among all employees
    Examples:
    | RequestType | Uri                                      |ResourceApi| StatusCode |Employee             |
    | GET         | http://dummy.restapiexample.com/api/v1   |employees  |200         |Michael Silva        |

  @CreateEmployee
  Scenario Outline: As a user, I want create the employees through services to carry out this process more quickly
    Given I make the connection to the api "<Uri>" with resource api "<ResourceApi>"
    When execute the method "<RequestType>" to create the employee "<Employee>" with salary "<Salary>" and "<Age>"
    Then I see that the state is returned "<StatusCode>"
    And Check if the "<Employee>" was created successfully
    Examples:
      | RequestType | Uri                                      |ResourceApi| StatusCode |Employee         |Salary     |Age|
      | POST        | http://dummy.restapiexample.com/api/v1/  |create     |200         |Diego Zapata     |12321      |25 |
      | POST        | http://dummy.restapiexample.com/api/v1/  |create     |200         |                 |12321      |25 |
      | POST        | http://dummy.restapiexample.com/api/v1/  |create     |200         |Diego Zapata     |12321      |-25|
      | POST        | http://dummy.restapiexample.com/api/v1/  |create     |200         |Diego Zapata     |500.000.001|25 |
      | POST        | http://dummy.restapiexample.com/api/v1/  |create     |200         |5113213221       |100.000    |25 |

  @GetAnEmployee
  Scenario Outline: As a user, I want consult one employee through services to carry out this process more quickly
    Given I make the connection to the api "<Uri>" with resource api "<ResourceApi>"
    When execute the method "<RequestType>"
    Then I see that the state is returned "<StatusCode>"
    And I check if the "<Employee>" exists
    And I check the message "<Message>"
    Examples:
      | RequestType | Uri                                      |ResourceApi  | StatusCode |Employee   | Message      |
      | GET         | http://dummy.restapiexample.com/api/v1   |employee/20  |200         |Dai Rios   | Successfully |
      | GET         | http://dummy.restapiexample.com/api/v1   |employee/-100|429         |           | Too Many Requests |

  @DeleteAnEmployee
  Scenario Outline: As a user, I want delete one employee through services to carry out this process more quickly
    Given I make the connection to the api "<Uri>" with resource api "<ResourceApi>"
    When execute the method "<RequestType>"
    Then I see that the state is returned "<StatusCode>"
    And I check the message "<Message>"
    Examples:
      | RequestType | Uri                                      |ResourceApi| StatusCode | Message           |
      | DELETE      | http://dummy.restapiexample.com/api/v1   |delete/20  |200         | deleted           |
      | DELETE      | http://dummy.restapiexample.com/api/v1   |delete/-%  |404         | Not Found         |
      | DELETE      | http://dummy.restapiexample.com/api/v1   |delete/4   |429         | Too Many Requests |