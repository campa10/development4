package com.javatodev.api.controller;

import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.model.Course;
import com.javatodev.api.service.CourseService;
import com.javatodev.api.service.FilterCoursesService;
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
    private final FilterCoursesService filterCoursesService;

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        List<Course> courses = courseService.findCourses();
        return new ResponseEntity<>(courses, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") Long id) throws RecordNotFoundException {
        //Validamos el ID
        //Parseamos y mandamos un request (???)
        //Devolvemos otro objeto que no sea la entidad;
        Course course = courseService.findById(id);
        return new ResponseEntity<>(course, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/studentName")
    public ResponseEntity<List<Course>> findCoursesByCourseName(@RequestParam String name) {
        List<Course> courses = filterCoursesService.findByStudentName(name);
        return new ResponseEntity<>(courses, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/withoutStudents")
    public ResponseEntity<List<Course>> findCoursesWithoutCourse() {
        List<Course> courses = filterCoursesService.findAllCoursesWithoutAnyStudents();
        return new ResponseEntity<>(courses, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) throws Exception {
        Course createdCourse = courseService.createOrUpdateCourse(course);
        return new ResponseEntity<>(createdCourse, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Course> update(@RequestBody Course course) throws Exception {
        Course updatedCourse = courseService.createOrUpdateCourse(course);
        return new ResponseEntity<>(updatedCourse, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) throws RecordNotFoundException {
        courseService.deleteById(id);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }
/*
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> readProducts () {
        return ResponseEntity.ok(courseService.readProducts());
    }

    @PostMapping
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Course> createOrUpdateRol(@RequestBody Course entity) throws Exception {
        Course updated = courseService.createOrUpdateCourses(entity);
        return new ResponseEntity<Course>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public HttpStatus deleteRolById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        courseService.deleteById(id);
        return HttpStatus.FORBIDDEN;
    }


 */
}
