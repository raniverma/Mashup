package com.stackroute.exceptions;

/*User defined exception for checking duplicate question*/
public class QuestionAlreadyExistsException extends Exception {

    public QuestionAlreadyExistsException(String message) {
        super(message);
    }
}
