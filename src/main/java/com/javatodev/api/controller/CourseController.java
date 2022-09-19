package com.javatodev.api.controller;

import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.model.Course;
import com.javatodev.api.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> readProducts () {
        return ResponseEntity.ok(courseService.readProducts());
    }

    @PostMapping
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Course> createOrUpdateRol(@RequestBody Course entity) throws RecordNotFoundException {
        Course updated = courseService.createOrUpdateCourses(entity);
        return new ResponseEntity<Course>(updated, new HttpHeaders(), HttpStatus.OK);
    }
}
