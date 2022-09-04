package com.lulobank.questions;

import com.lulobank.utils.Show;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.lulobank.utils.Constants.JSON_PATH_GET_EMPLOYEES;
import static com.lulobank.utils.Constants.*;

public class ValidateEmployees implements Question<String> {
    private final String user;
    public ValidateEmployees(String user) {
        this.user = user;
        }
    @Override
    public String answeredBy(Actor actor) {
        if(actor.recall(RESPONSE).toString().contains(user)){
            Show.information(ValidateEmployees.class, THE_USER + SPACE + user + SPACE + DOES_EXIST + SPACE + RESPONSE_JSONPATH +
                    JsonPath.from(actor.recall(RESPONSE).toString()).get(String.format(JSON_PATH_GET_EMPLOYEES, user)).toString());
            return JsonPath.from(actor.recall(RESPONSE).toString()).get(String.format(JSON_PATH_GET_EMPLOYEES, user)).toString();
        }
        return THE_EMPLOYEE_DOES_NOT_EXIST;
    }

    public static ValidateEmployees responseEmployees(String user) {
        return new ValidateEmployees(user);
    }
}