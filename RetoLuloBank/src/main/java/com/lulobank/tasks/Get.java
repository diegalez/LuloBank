package com.lulobank.tasks;

import com.lulobank.utils.Show;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import static com.lulobank.utils.Constants.*;

public class Get implements Task {

    @Step("{0} consume get method")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Response response = SerenityRest.given().relaxedHTTPSValidation().baseUri(actor.recall(URI)).contentType(CONTENT_TYPE).and().log().all().
                when().get(SLASH + actor.recall(RESOURCE_API)).
                then().extract().response();
        Show.information(Get.class, RESPONSE_PATH + response.getBody().asString());
        actor.remember(RESPONSE, response.getBody().asString());
        actor.remember(STATUS_CODE,response.getStatusCode());
    }

    public static Get information() {
        return Tasks.instrumented(Get.class);
    }
}