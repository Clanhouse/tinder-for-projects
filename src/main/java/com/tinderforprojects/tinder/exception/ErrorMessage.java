package com.tinderforprojects.tinder.exception;

public enum ErrorMessage {

    NOT_FOUND("Resource does not exists"),
    BAD_REQUEST("Bad request - check documentation");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
