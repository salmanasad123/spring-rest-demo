package com.luv2code.springdemo.rest;

// our pojo class to represent error, objects of this class will be sent as error response
public class StudentErrorResponse {

    int statusCode;
    long timeStamp;
    String errorMessage;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int statusCode, long timeStamp, String errorMessage) {
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
