package com.abc.raja;

public class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(Integer id) {
        super("Could not find employee: " + id);
    }
}
