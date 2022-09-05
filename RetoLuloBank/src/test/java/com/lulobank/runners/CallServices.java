package com.lulobank.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"com.lulobank.stepdefinitions"},
        features = {"src/test/resources/features/call_services.feature"},
        tags = {"@GetEmployees"},
        //tags = {"@CreateEmployee"},
        //tags = {"@GetAnEmployee"},
        //tags = {"@DeleteAnEmployee"},
        monochrome = true,
        strict = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CallServices {
}