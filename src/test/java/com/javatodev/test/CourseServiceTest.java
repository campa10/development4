package com.javatodev.test;

import com.javatodev.api.repository.CourseRepository;
import com.javatodev.api.repository.EnrollmentRepository;
import com.javatodev.api.service.EnrollmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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

    /*@Test
    void readProducts() {
    }*/
}