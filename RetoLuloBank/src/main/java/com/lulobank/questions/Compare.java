package com.lulobank.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.lulobank.utils.Constants.STATUS_CODE;

public class Compare implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return actor.recall(STATUS_CODE).toString();
    }

    public static Compare responseStatusCode() {
        return new Compare();
    }
}
