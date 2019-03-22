package com.stackroute.exception;

public class UserProfileNotFoundException extends Exception {
    public UserProfileNotFoundException() {}
    public UserProfileNotFoundException(String message) {
        super(message);
    }
}
