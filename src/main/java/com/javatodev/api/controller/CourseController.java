package com.javatodev.api.controller;

import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.model.Course;
import com.javatodev.api.service.CourseService;
import com.javatodev.api.service.FilterService;
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
    private final FilterService filterService;

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        List<Course> courses = courseService.findCourses();
        return new ResponseEntity<>(courses, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") Long id) throws RecordNotFoundException {
        Course course = courseService.findById(id);
        return new ResponseEntity<>(course, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> createOrUpdate(@RequestBody Course course) throws Exception {
        Course createdCourse = courseService.createOrUpdateCourse(course);
        return new ResponseEntity<>(createdCourse, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) throws RecordNotFoundException {
        courseService.deleteById(id);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/studentName")
    public ResponseEntity<List<Course>> findCourseByStudentName(@RequestParam String name) {
        List<Course> courses = filterService.findCourseByStudentName(name);
        return new ResponseEntity<>(courses, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/withoutStudents")
    public ResponseEntity<List<Course>> findCoursesWithoutStudents() {
        List<Course> courses = filterService.findAllCoursesWithOutAnyStudent();
        return new ResponseEntity<>(courses, new HttpHeaders(), HttpStatus.OK);
    }

}
