package com.javatodev.api.controller;

import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.model.Student;
import com.javatodev.api.service.FilterService;
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
    private final FilterService filterService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = studentService.findStudents();
        return new ResponseEntity<>(students, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Long id) throws RecordNotFoundException {
        Student student = studentService.findById(id);
        return new ResponseEntity<>(student, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createOrUpdate(@RequestBody Student student) throws Exception {
        Student createdStudent = studentService.createOrUpdateStudent(student);
        return new ResponseEntity<>(createdStudent, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) throws RecordNotFoundException {
        studentService.deleteById(id);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/courseName")
    public ResponseEntity<List<Student>> findStudentByCourseName(@RequestParam String name) {
        List<Student> students = filterService.findStudentByCourseName(name);
        return new ResponseEntity<>(students, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/withoutCourse")
    public ResponseEntity<List<Student>> findStudentsWithoutCourse() {
        List<Student> students = filterService.findAllStudentsWithoutAnyCourses();
        return new ResponseEntity<>(students, new HttpHeaders(), HttpStatus.OK);
    }

}
