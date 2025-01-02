package com.youngho.restsecurity_day1.advice;

import com.youngho.restsecurity_day1.exception.MemberAlreadyExistsException;
import com.youngho.restsecurity_day1.exception.ProjectAlreadyExistsException;
import com.youngho.restsecurity_day1.exception.ProjectMemberAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionAdvice {

    @ExceptionHandler({ProjectAlreadyExistsException.class, MemberAlreadyExistsException.class, ProjectMemberAlreadyExistsException.class})
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        return new ResponseEntity<>("server Error", HttpStatus.CONFLICT);
    }
}
