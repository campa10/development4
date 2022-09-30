package com.javatodev.api.service;

import com.javatodev.api.model.Student;
import com.javatodev.api.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilterStudentsService {

    @Autowired
    private final StudentRepository studentRepository;

    public List<Student> findCourseBy(String courseName) {
        return studentRepository.findCourseBy(courseName);
    }

    public List<Student> findAllStudentsWithoutAnyCourses() {
        return studentRepository.findAllStudentsWithoutAnyCourses();
    }
}
