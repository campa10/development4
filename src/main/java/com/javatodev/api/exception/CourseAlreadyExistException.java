package com.javatodev.api.exception;

public class CourseAlreadyExistException extends RuntimeException {

    public CourseAlreadyExistException(String message) {
        super(message);
    }

}
