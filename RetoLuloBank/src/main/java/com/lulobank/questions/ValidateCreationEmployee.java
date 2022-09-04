package com.lulobank.questions;

import com.lulobank.utils.Show;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.lulobank.utils.Constants.*;

public class ValidateCreationEmployee implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
         Show.information(ValidateCreationEmployee.class, RESPONSE_PATH + JsonPath.from(actor.recall(RESPONSE).toString()).get(JSON_PATH_POST_EMPLOYEE_NAME).toString());
         return JsonPath.from(actor.recall(RESPONSE).toString()).get(JSON_PATH_POST_EMPLOYEE_NAME).toString();
    }
    public static ValidateCreationEmployee inTheResponse() {
        return new ValidateCreationEmployee();
    }
}
