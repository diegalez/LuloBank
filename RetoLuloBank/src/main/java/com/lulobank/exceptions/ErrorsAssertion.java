package com.lulobank.exceptions;

public class ErrorsAssertion extends AssertionError{
    public static final String THE_CODES_DO_NOT_MATCH = "Los codigos no son iguales";
    public static final String WRONG_DATA_FOR_THE_CREATION = "La edad no puede ser negativa , \nel salario no puede ser superior a 500.000.000 ,\nel nombre no puede ser vacio, \nno se aceptan numeros en el nombre del empleado\n Verifique la información";
    public static final String USERNAME_DOES_NOT_EXIST = "El empleado no existe";
    public static final String THE_MESSAGES_ARE_NOT_THE_SAME = "Los mensajes no conciden";

    public static final String THE_EMPLOYEE_WAS_NOT_CREATED_SUCCESSFULLY = "El empleado no se creó exitosamente";

    public ErrorsAssertion(String message) {
        super(message);
    }

    public ErrorsAssertion(String message, Throwable testErrorException) {
        super(message, testErrorException);

    }
}
