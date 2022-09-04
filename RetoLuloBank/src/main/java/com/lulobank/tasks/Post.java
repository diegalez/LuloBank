package com.lulobank.tasks;

import com.google.gson.Gson;
import static com.lulobank.exceptions.ErrorsAssertion.*;
import com.lulobank.exceptions.ErrorsAssertion;
import com.lulobank.models.Employee;
import com.lulobank.questions.EmployeeCreationControl;
import com.lulobank.utils.Show;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import static com.lulobank.utils.Constants.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class Post implements Task {

    private final String employee;
    private final String salary;
    private final String age;

    public Post(String employee, String salary, String age) {
        this.employee = employee;
        this.salary = salary;
        this.age = age;
    }

    @Step("{0} consume post method")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(seeThat(EmployeeCreationControl.beforeExecution(employee, salary, age), is(equalTo(false)))
                .orComplainWith(ErrorsAssertion.class, WRONG_DATA_FOR_THE_CREATION));

        Employee dataEmployee = Employee.builder()
                .name(employee)
                .salary(salary)
                .age(age)
                .build();
        Gson gson = new Gson();
        String gsonJson = gson.toJson(dataEmployee);

        Response response = SerenityRest.given().relaxedHTTPSValidation().baseUri(actor.recall(URI)).contentType(CONTENT_TYPE)
                .body(gsonJson).and().log().all().
                when().post(SLASH + actor.recall(RESOURCE_API)).
                then().extract().response();
        actor.remember(RESPONSE, response.getBody().asString());
        actor.remember(STATUS_CODE,response.getStatusCode());
        actor.remember(ID_EMPLOYEE, JsonPath.from(response.getBody().asString()).get(JSON_PATH_GET_EMPLOYEE_ID).toString());
        Show.information(Post.class, ID_EMPLOYEE_ + actor.recall(ID_EMPLOYEE).toString());
        Show.information(Post.class, STATUS_CODE_ + response.getStatusCode());

    }
    public static Post create(String employee, String salary, String age) {
        return Tasks.instrumented(Post.class,  employee, salary, age);
    }
}