package com.lulobank.questions;

import com.lulobank.utils.Show;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.lulobank.utils.Constants.*;
public class ValidateEmployee implements Question<String> {

    private final String jsonPath;

    public ValidateEmployee(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    @Override
    public String answeredBy(Actor actor) {
        if (CODE_404.equals(actor.recall(STATUS_CODE).toString())) {
            return actor.recall(RESPONSE).toString();
        }
        else if  (CODE_429.equals(actor.recall(STATUS_CODE).toString())){
            return  EMPTY;
        } else {
            Show.information(ValidateEmployee.class, RESPONSE_PATH + JsonPath.from(actor.recall(RESPONSE).toString()).get(jsonPath).toString());
            return JsonPath.from(actor.recall(RESPONSE).toString()).get(jsonPath).toString();
        }
    }

    public static ValidateEmployee inTheResponse(String jsonPath) {
        return new ValidateEmployee(jsonPath);
    }
}
