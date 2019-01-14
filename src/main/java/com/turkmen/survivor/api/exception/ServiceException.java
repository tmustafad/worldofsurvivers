package com.turkmen.survivor.api.exception;



/**
 * <h1>The exception class which is used in service layer</h1>
 *
 *
 *
 *
 * @author  Turkmen
 * @see MainError
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class ServiceException extends RuntimeException {
    private final MainError error;

    public ServiceException(MainError error) {
        this.error = error;
    }

    public MainError getError() {
        return error;
    }
}
