package com.javatodev.api.controller;

import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.model.Enrollment;
import com.javatodev.api.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {


    private final EnrollmentService enrollmentService;

    @PostMapping(value = "/add")
    public ResponseEntity<Enrollment> createOrUpdateEnrollment(@RequestBody Enrollment entity) throws RecordNotFoundException {
        Enrollment updated = enrollmentService.createOrUpdateEnrollment(entity);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> findAll() {
        List<Enrollment> enrollments = enrollmentService.findEnrollments();
        return new ResponseEntity<>(enrollments, new HttpHeaders(), HttpStatus.OK);
    }

}
