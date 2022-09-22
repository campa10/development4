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

    private final EnrollmentService studentService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> readProducts () {
        return ResponseEntity.ok(studentService.readStudents());
    }

    @RequestMapping(value = "/enrollment", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> enrollment () {
        return ResponseEntity.ok(studentService.getAll());
    }

    @PostMapping
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Enrollment> createOrUpdateRol(@RequestBody Enrollment entity) throws RecordNotFoundException {
        Enrollment updated = studentService.createOrUpdateStudents(entity);
        return new ResponseEntity<Enrollment>(updated, new HttpHeaders(), HttpStatus.OK);
    }
}
