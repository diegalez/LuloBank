package com.lulobank.interactions;

import com.lulobank.tasks.Delete;
import com.lulobank.tasks.Get;
import com.lulobank.tasks.Post;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import static com.lulobank.utils.Constants.*;

public class TypeRequest implements Interaction {
    private final String requestType;
    private  String employee;
    private  String salary;
    private  String age;

    public TypeRequest(String requestType) {
        this.requestType = requestType;
    }

    public TypeRequest(String requestType, String employee, String salary, String age) {
        this.requestType = requestType;
        this.employee = employee;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(REQUEST_TYPE,requestType);
        if(GET.equals(requestType)){
            actor.attemptsTo(Get.information());
        }else if(POST.equals(requestType)){
            actor.attemptsTo(Post.create(employee,salary,age));
        }else {
            actor.attemptsTo(Delete.employee());
        }
    }

    public static TypeRequest information(String requestType) {
        return Tasks.instrumented(TypeRequest.class, requestType);
    }
    public static TypeRequest information(String requestType,String employee, String salary, String age) {
        return Tasks.instrumented(TypeRequest.class, requestType, employee, salary, age);
    }
}
