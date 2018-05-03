package com.cs.draw.helper;

/**
 * Signals that Application exception of some sort has occured.
 * Details of the exception will be in message.
 */
public class ApplicationException extends Exception {


    String message;

    public ApplicationException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
