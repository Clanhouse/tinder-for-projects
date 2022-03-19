package com.tinderforprojects.tinder.exception.notFound;

import com.tinderforprojects.tinder.exception.ErrorMessage;

public class NotFoundException extends RuntimeException {

    private ErrorMessage errorMessage;

    public NotFoundException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

}
