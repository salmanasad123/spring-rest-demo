package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // add exception handling code here
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {

        // create StudentErrorResponse
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setErrorMessage(ex.getMessage());
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return responseEntity

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // add another exception handler to handle any type of exception being thrown, not handling a specific one
    // so this will send a json response instead of the Exception html generic Page
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAnyTypeOfException(Exception exception) {

        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setErrorMessage(exception.getMessage());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

}
