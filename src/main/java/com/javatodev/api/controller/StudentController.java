package com.javatodev.api.controller;

import com.javatodev.api.model.Course;
import com.javatodev.api.model.Student;
import com.javatodev.api.service.CourseService;
import com.javatodev.api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> readProducts () {
        return ResponseEntity.ok(studentService.readProducts());
    }

    @PostMapping
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Student> createOrUpdateRol(@RequestBody Student entity) throws Exception {
        Student updated = studentService.createOrUpdateCourses(entity);
        return new ResponseEntity<Student>(updated, new HttpHeaders(), HttpStatus.OK);
    }
}
