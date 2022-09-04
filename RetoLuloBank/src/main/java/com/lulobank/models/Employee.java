package com.lulobank.models;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
@Data
public class Employee {
    private String name;
    private String salary;
    private String age;
}
