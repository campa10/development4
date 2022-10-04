package com.javatodev.api.exception;

public class StudentAlreadyExistException extends RuntimeException {

    public StudentAlreadyExistException(String message) {
        super(message);
    }

    public StudentAlreadyExistException(String message, Throwable t) {
        super(message, t);
    }
}
