package com.github.clanhouse.tinderforprojects.tinderforprojects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerExceptionHandler {

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity<ErrorInfo> handleException(ControllerException e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ControllerError.NOT_FOUND.equals(e.getStudentError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(httpStatus).body(new ErrorInfo(e.getStudentError().getMessage()));
    }

}
