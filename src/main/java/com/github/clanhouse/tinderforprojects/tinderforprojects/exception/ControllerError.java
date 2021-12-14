package com.github.clanhouse.tinderforprojects.tinderforprojects.exception;

public enum ControllerError {

    NOT_FOUND("Resource not found"),
    EMPTY("Resource has no content"),
    EXISTS("Resource already exists");

    private String message;

    ControllerError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
