package com.stackroute.exception;

import java.util.Date;

public class CustomizedErrorResponseStructure {
    private Date timestamp;
    private String message;
    private String details;
    public CustomizedErrorResponseStructure(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }
    public String getDetails() {
        return details;
    }
}