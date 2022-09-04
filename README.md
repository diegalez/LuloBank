Automation challenge Lulo
Introduction 🚀
Automation made for a challenge, with transactions to call API.

* This challenge is created to consume through the GET , POST and DELETE methods the service http://dummy.restapiexample.com/api/v1/
and validate different answers that it can answer.

+ Sensations: The api is very unstable which makes it a bit difficult to control when one response or another is going to come out, the api does not have the error messages well mapped and it does not control much errors either to have a wide variety of possibilities to test the messages or codes that returns, however it was a big challenge to automate this API.

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


Pre requirements to execute 📋
Java version 1.8, update 151 or higher and JDK (environment variables configured).
Eclipse IDE or IntelliJ IDEA (version 2018.3 or higher).
Maven Compiler.
Cucumber for Java Plugin (updated version).
Gherkin Plugin (updated version).


Installation 🔧
To clone this repository locally, the following command must be run: git clone https://github.com/diegalez/LuloBank.git or download with ZIP
Import the project from Eclipse or IntelliJ IDE.
Configure the encoding to UTF-8 to the project once it is imported.
Compile the project with the command mvn compile and mvn clean or use the plugin compiler in the IDE 🔨

Execution 💻
The project can be executed from the console with the following command: mvn clean


Project structure 🚧
src/main/java/com/lulobank/
+ exceptions
    Classes that catch custom exceptions when automation fails and cannot find an expected field.

+ models
    Classes with which the data models are built using the builder pattern.

+ questions
    Classes with which values are obtained and then verified in the stepdefinitions (asserts).

+ tasks
    Classes that perform high-level actions, such as login in the application, enter data into a form, etc.

+ interactions
    Classes that help to interact with the user interface or with APIs

+ utils
    Classes that contain common functionalities.

src/test/java/com/lulobank/
+ runners
    Classes to run automation with the scenarios indicated in the feature.

+ stepdefinitions
    Classes that are the entry point of the feature to translate from Gherkin language to machine language and thus allow the execution of automation.
src/test/resources/

+ features
    The project features are found.

Built with 🛠
Automation was developed with:

BDD - Development strategy
Screenplay - Design pattern
Maven - Dependency manager
Cucumber5 - Is a software tool that supports behavior-driven development
Serenity BDD - open source library that helps write higher quality automated acceptance tests more efficiently
Gherkin - Business Readable DSL Language (Business-readable domain specific language)
Serenity Rest - Library that allows us to consume services
Hamscrest - Hamcrest is a framework for writing matcher objects allowing 'match' rules to be defined
GSON - Is an open source library that allows serialization and deserialization between Java objects and their representation in JSON notation.
Lombok annotations - It is a library for Java that through annotations reduces the code that we code

Versioning 📌
Git was used for version control, applying GitFlow 🔀

Thanks !!

Authors 👨
Diego Alejandro Zapata Betancur - dazb12@hotmail.com