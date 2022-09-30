package com.javatodev.test.service;

import com.javatodev.api.model.Student;
import com.javatodev.api.repository.StudentRepository;
import com.javatodev.api.service.FilterStudentsService;
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

class FilterStudentsServiceTest {

    private static FilterStudentsService filterStudentsService;

    private static final StudentRepository studentRepository = mock(StudentRepository.class);

    @BeforeAll
    static void setUp() {
        filterStudentsService = new FilterStudentsService(studentRepository);
    }

    @Test
    void shouldFindStudentsWithASpecificCourseTest() {
        //given:
        String courseName = "course1";
        when(studentRepository.findCourseBy(courseName)).thenReturn(expectedStudents());

        //when:
        List<Student> students = filterStudentsService.findCourseBy(courseName);

        //then:
        assertThat(students, equalTo(expectedStudents()));
    }

    @Test
    void shouldReturnEmptyListWithASpecificCourseTest() {
        //given:
        String courseName = "course1";
        when(studentRepository.findCourseBy(courseName)).thenReturn(Collections.emptyList());

        //when:
        List<Student> students = filterStudentsService.findCourseBy(courseName);

        //then:
        assertTrue(students.isEmpty());
    }

    @Test
    void shouldReturnAllStudentsWithoutAnyCourses(){
        //given:
        when(studentRepository.findAllStudentsWithoutAnyCourses()).thenReturn(expectedStudents());

        //when:
        List<Student> students = filterStudentsService.findAllStudentsWithoutAnyCourses();

        //then:
        assertThat(students, equalTo(expectedStudents()));
    }

    @Test
    void shouldReturnEmptyListOfStudentsWithoutAnyCourses(){
        //given:
        when(studentRepository.findAllStudentsWithoutAnyCourses()).thenReturn(Collections.emptyList());

        //when:
        List<Student> students = filterStudentsService.findAllStudentsWithoutAnyCourses();

        //then:
        assertTrue(students.isEmpty());
    }

    private List<Student> expectedStudents() {
        return Arrays.asList(
                new Student(1L, "Ringo"),
                new Student(2L, "John"),
                new Student(3L, "Paul"),
                new Student(4L, "George"));
    }

}
