package com.shankar.mysqlIntegration.MysqlIntegration.ExceptionHandling;

public class EmployeeIDNotAvailableException extends RuntimeException {

    public EmployeeIDNotAvailableException(String exceptionMessage){
        super(exceptionMessage);
    }
}
