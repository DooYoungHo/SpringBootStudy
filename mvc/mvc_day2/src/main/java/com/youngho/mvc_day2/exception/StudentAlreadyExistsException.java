package com.youngho.mvc_day2.exception;

public class StudentAlreadyExistsException extends RuntimeException {

    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}
