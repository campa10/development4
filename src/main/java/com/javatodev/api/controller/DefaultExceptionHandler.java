package com.javatodev.api.controller;

import com.javatodev.api.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlerRecordNotFoundException(RecordNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NO_CONTENT.value(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NO_CONTENT);
    }

    @ResponseBody
    @ExceptionHandler(CourseAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> handlerCourseAlreadyExistException(CourseAlreadyExistException e) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(StudentAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> handlerStudentAlreadyExistException(StudentAlreadyExistException e) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(CourseEnrolledExceedException.class)
    public ResponseEntity<ErrorMessage> handlerCourseEnrolledExceed(CourseEnrolledExceedException e) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
