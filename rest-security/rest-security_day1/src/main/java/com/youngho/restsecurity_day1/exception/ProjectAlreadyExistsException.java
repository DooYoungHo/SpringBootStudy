package com.youngho.restsecurity_day1.exception;

public class ProjectAlreadyExistsException extends RuntimeException {

    public ProjectAlreadyExistsException(String message) {
        super(message);
    }
}
