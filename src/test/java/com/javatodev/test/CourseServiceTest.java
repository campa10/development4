package com.javatodev.test;

import com.javatodev.api.model.Course;
import com.javatodev.api.repository.CourseRepository;
import com.javatodev.api.repository.EnrollmentRepository;
import com.javatodev.api.service.EnrollmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@Disabled
@SpringBootTest
class CourseServiceTest {

    EnrollmentService enrollmentService;
    EnrollmentRepository enrollmentRepository;
    CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        enrollmentService = mock(EnrollmentService.class);
        enrollmentRepository = mock(EnrollmentRepository.class);
        courseRepository = mock(CourseRepository.class);
    }

    @Test
    void readProducts() {
        Course course = new Course();
        List<Course> courses = new ArrayList<>();
        course.setId(101L);
        course.setCoursename("course101");
        courses.add(course);
        List<Course> results = (List<Course>) Mockito.when(courseRepository.findAll()).thenReturn(courses);
        Assertions.assertTrue(results.get(0).getCoursename().equals(course.getCoursename()));
    }
}