package com.github.clanhouse.tinderforprojects.tinderforprojects.exception;

public class ControllerException extends RuntimeException{

    private ControllerError controllerError;

    public ControllerException(ControllerError controllerError) {
        this.controllerError = controllerError;
    }

    public ControllerError getError() {
        return controllerError;
    }

}
