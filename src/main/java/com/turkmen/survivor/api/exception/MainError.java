package com.turkmen.survivor.api.exception;



/**
 * <h1>The Error Class of the whole application</h1>
 *
 *
 *
 *
 * @author  Turkmen
 * @see ServiceException
 * @version 1.0
 * @since   2019-01-14
 *
 *
 */
public class MainError {

    protected int code;
    protected String message;

    public MainError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public MainError(String message) {
        this(400, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
