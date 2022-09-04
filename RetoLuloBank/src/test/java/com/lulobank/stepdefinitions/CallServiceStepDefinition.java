package com.lulobank.stepdefinitions;
import com.lulobank.exceptions.ErrorsAssertion;
import com.lulobank.interactions.TypeRequest;
import com.lulobank.questions.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.lulobank.exceptions.ErrorsAssertion.*;
import static com.lulobank.utils.Constants.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
public class CallServiceStepDefinition {

    @Before
    public static void configActor() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("actor");
    }
    @Given("I make the connection to the api {string} with resource api {string}")
    public void iMakeTheConnectionToTheApiHttpDummyRestApiAndResourceApi(String uri,String resourceApi) {
        theActorCalled("actor").whoCan(CallAnApi.at(uri));
        theActorInTheSpotlight().remember("URI", uri);
        theActorInTheSpotlight().remember("RESOURCE_API", resourceApi);
    }
    @When("execute the method {string}")
    public void executeTheMethod(String requestType) {
        theActorInTheSpotlight().attemptsTo(TypeRequest.information(requestType));
    }

    @When("execute the method {string} to create the employee {string} with salary {string} and {string}")
    public void executeTheMethodToCreateTheEmployeeWithDataUser(String requestType, String employeeName, String salary, String age) {
        theActorInTheSpotlight().attemptsTo(TypeRequest.information(requestType, employeeName, salary, age));
    }

    @Then("I see that the state is returned {string}")
    public void iSeeThatTheStateIsReturned(String statusCode) {
        theActorInTheSpotlight().should(seeThat(Compare.responseStatusCode(), is(equalTo(statusCode)))
                .orComplainWith(ErrorsAssertion.class, THE_CODES_DO_NOT_MATCH));
    }

    @Then("I check if the user {string} exists among all employees")
    public void iCheckIfTheUserExistsAmongAllEmployees(String user) {
        theActorInTheSpotlight().should(seeThat(ValidateEmployees.responseEmployees(user),  containsString(user))
                .orComplainWith(ErrorsAssertion.class, USERNAME_DOES_NOT_EXIST));
    }

    @Then("I check if the {string} exists")
    public void iCheckIfTheExists(String employee) {
        theActorInTheSpotlight().should(seeThat(ValidateEmployee.inTheResponse(JSON_PATH_GET_EMPLOYEE_NAME), is(equalTo(employee)))
                .orComplainWith(ErrorsAssertion.class, USERNAME_DOES_NOT_EXIST));
    }

    @Then("I check the message {string}")
    public void iCheckTheMessage(String message) {
        theActorInTheSpotlight().should(seeThat(ValidateMessage.inTheResponse(JSON_PATH_GET_MESSAGE), containsString(message))
                .orComplainWith(ErrorsAssertion.class, THE_MESSAGES_ARE_NOT_THE_SAME));

    }

    @Then("Check if the {string} was created successfully")
    public void checkIfTheWasCreatedSuccessfully(String employee) {
        theActorInTheSpotlight().should(seeThat(ValidateCreationEmployee.inTheResponse(),  containsString(employee))
                .orComplainWith(ErrorsAssertion.class, THE_EMPLOYEE_WAS_NOT_CREATED_SUCCESSFULLY));
    }



}
