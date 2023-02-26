package com.furkant.exception.handling.exception;

public class UserAlreadySavedException extends RuntimeException {
    private static final long serialVersionUID = -3958909312842740865L;

    public UserAlreadySavedException(String message) {
        super(message);
    }
}
