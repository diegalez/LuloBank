package com.lulobank.questions;

import static com.lulobank.utils.Constants.*;
import static com.lulobank.utils.Utils.containsOnlyLetter;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EmployeeCreationControl implements Question<Boolean> {

    private final String employee;
    private  String salary;
    private final String age;

    public EmployeeCreationControl(String employee, String salary, String age) {
        this.employee = employee;
        this.salary = salary;
        this.age = age;
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        if(salary.contains(DOT)){
        this.salary = salary.replace(DOT, EMPTY);
        }
        if(MIDDLE_DASH.equals(String.valueOf(age.charAt(0)))) {
           return true;
        }else if (Integer.parseInt(FIVE_HUNDRED_MILLION) < Integer.parseInt(this.salary)){
            return true;
        }else if (employee.equals(EMPTY)){
            return true;
        }else return !containsOnlyLetter(employee);
    }


    public static EmployeeCreationControl beforeExecution(String employee, String salary, String age) {
        return new EmployeeCreationControl( employee, salary, age);
    }
}
