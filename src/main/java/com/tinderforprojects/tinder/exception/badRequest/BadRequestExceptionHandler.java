package com.tinderforprojects.tinder.exception.badRequest;

import com.tinderforprojects.tinder.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BadRequestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleException() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ErrorMessage.BAD_REQUEST.getMessage());
    }

   @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", ex.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
