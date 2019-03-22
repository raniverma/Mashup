package com.stackroute.exception;

public class UserProfileAlreadyExistException extends Exception {
    public UserProfileAlreadyExistException() {}
    public UserProfileAlreadyExistException(String message) {
        super(message);
    }
}
