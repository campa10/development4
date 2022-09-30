package com.javatodev.api.service;

import com.javatodev.api.model.Course;
import com.javatodev.api.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FilterCoursesService {

    private final CourseRepository courseRepository;

    public List<Course> findByStudentName(String studentName) {
        return courseRepository.findByStudentName(studentName);
    }

    public List<Course> findAllCoursesWithoutAnyStudents() {
        return courseRepository.findAllCoursesWithoutAnyStudents();
    }
}
