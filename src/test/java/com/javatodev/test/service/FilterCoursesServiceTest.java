package com.javatodev.test.service;

import com.javatodev.api.model.Course;
import com.javatodev.api.repository.CourseRepository;
import com.javatodev.api.service.FilterCoursesService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FilterCoursesServiceTest {

    private static FilterCoursesService filterCoursesService;

    private static final CourseRepository courseRepository = mock(CourseRepository.class);

    @BeforeAll
    static void setUp() {
        filterCoursesService = new FilterCoursesService(courseRepository);
    }

    @Test
    void shouldReturnAllCoursesForASpecificStudent() {
        //given:
        String studentName = "John";
        when(courseRepository.findByStudentName(studentName)).thenReturn(expectedCourses());

        //when:
        List<Course> courses = filterCoursesService.findByStudentName(studentName);

        //then:
        assertThat(courses, equalTo(expectedCourses()));
    }

    @Test
    void shouldReturnEmptyListOfCoursesForASpecificStudent() {
        //given:
        String studentName = "John";
        when(courseRepository.findByStudentName(studentName)).thenReturn(Collections.emptyList());

        //when:
        List<Course> courses = filterCoursesService.findByStudentName(studentName);

        //then:
        assertTrue(courses.isEmpty());
    }

    @Test
    void shouldReturnAllCoursesWithoutAnyStudents() {
        //given:
        when(courseRepository.findAllCoursesWithoutAnyStudents()).thenReturn(expectedCourses());

        //when:
        List<Course> courses = filterCoursesService.findAllCoursesWithoutAnyStudents();

        //then:
        assertThat(courses, equalTo(expectedCourses()));
    }

    @Test
    void shouldEmptyListOfCoursesWithoutAnyStudents() {
        //given:
        when(courseRepository.findAllCoursesWithoutAnyStudents()).thenReturn(Collections.emptyList());

        //when:
        List<Course> courses = filterCoursesService.findAllCoursesWithoutAnyStudents();

        //then:
        assertTrue(courses.isEmpty());
    }

    private List<Course> expectedCourses() {
        return Arrays.asList(
                new Course(1L, "Course 1"),
                new Course(1L, "Course 1")
        );
    }
}
