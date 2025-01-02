package com.youngho.restsecurity_day1.exception;

public class ProjectMemberAlreadyExistsException extends RuntimeException {

    public ProjectMemberAlreadyExistsException(String message) {
        super(message);
    }
}
