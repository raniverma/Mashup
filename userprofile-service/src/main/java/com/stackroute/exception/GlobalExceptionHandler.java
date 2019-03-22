package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserProfileNotFoundException.class)
    public ResponseEntity<CustomizedErrorResponseStructure> userProfileNotFoundException(UserProfileNotFoundException ex, WebRequest request) {
        CustomizedErrorResponseStructure errorDetails = new CustomizedErrorResponseStructure(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserProfileAlreadyExistException.class)
    public ResponseEntity<CustomizedErrorResponseStructure> userProfileAlreadyExistException(UserProfileAlreadyExistException ex, WebRequest request) {
        CustomizedErrorResponseStructure errorDetails = new CustomizedErrorResponseStructure(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomizedErrorResponseStructure> globleExcpetionHandler(Exception ex, WebRequest request) {
        CustomizedErrorResponseStructure errorDetails = new CustomizedErrorResponseStructure(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}