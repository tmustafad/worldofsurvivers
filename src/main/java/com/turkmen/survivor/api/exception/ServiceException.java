package com.turkmen.survivor.api.exception;

public class ServiceException extends RuntimeException {
    private final MainError error;

    public ServiceException(MainError error) {
        this.error = error;
    }

    public MainError getError() {
        return error;
    }
}
