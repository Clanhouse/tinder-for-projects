package com.tinderforprojects.tinder.exception.badRequest;

import com.tinderforprojects.tinder.exception.ErrorMessage;

public class BadRequestException extends RuntimeException {

    private ErrorMessage errorMessage;

    public BadRequestException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

}
