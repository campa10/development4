package com.javatodev.api.exception;

public class CourseAlreadyExistException extends RuntimeException {

    public CourseAlreadyExistException(String message) {
        super(message);
    }

    public CourseAlreadyExistException(String message, Throwable t) {
        super(message, t);
    }

}
