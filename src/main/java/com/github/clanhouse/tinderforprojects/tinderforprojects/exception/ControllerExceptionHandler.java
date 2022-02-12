package com.github.clanhouse.tinderforprojects.tinderforprojects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity<ErrorInfo> handleException(ControllerException e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ControllerError.NOT_FOUND.equals(e.getError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        if(ControllerError.BAD_REQUEST.equals(e.getError())){
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        if(ControllerError.EXISTS.equals(e.getError())){
            httpStatus = HttpStatus.CONFLICT;
        }
        if(ControllerError.EMPTY.equals(e.getError())){
            httpStatus = HttpStatus.NO_CONTENT;
        }
        return ResponseEntity.status(httpStatus).body(new ErrorInfo(e.getError().getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", ex.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
