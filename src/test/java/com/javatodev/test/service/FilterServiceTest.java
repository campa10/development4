package com.javatodev.test.service;

import com.javatodev.api.model.Course;
import com.javatodev.api.model.Student;
import com.javatodev.api.service.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FilterServiceTest {

    private static final CourseService courseService = mock(CourseService.class);
    private static final StudentService studentService = mock(StudentService.class);
    private static final EnrollmentService enrollmentService = mock(EnrollmentService.class);
    private static FilterService filterService;

    @BeforeAll
    static void setUp() {
        filterService = new FilterServiceImpl(courseService, studentService, enrollmentService);
    }


    @Test
    void findAllStudentsWithoutAnyCoursesShouldReturnListOfStudents() {
        //given:
        when(enrollmentService.findStudentsIds()).thenReturn(Arrays.asList(1L, 2L));
        when(studentService.findStudentByIdNotIn(any())).thenReturn(mockedStudents());

        //when:
        List<Student> students = filterService.findAllStudentsWithoutAnyCourses();

        //then:
        assertThat(students, equalTo(expectedStudentsWithCourse()));
    }

    @Test
    void findAllCoursesWithOutAnyStudentShouldReturnListOfStudents() {
        //given:
        when(enrollmentService.findCoursesIds()).thenReturn(Arrays.asList(1L, 2L));
        when(courseService.findCourseByIdNotIn(any())).thenReturn(expectedCourses());

        //when:
        List<Course> courses = filterService.findAllCoursesWithOutAnyStudent();

        //then:
        assertThat(courses, equalTo(expectedCourses()));
    }

    @Test
    void findStudentByCourseNameShouldReturnStudentsOfThatCourse() {
        //given:
        String name = "course1";
        when(courseService.findCourseByName(name)).thenReturn(expectedCourses());

        //when:
        List<Student> students = filterService.findStudentByCourseName(name);

        //then:
        assertThat(students, equalTo(expectedStudentsWithCourse()));
    }

    @Test
    void findCourseByStudentNameShouldReturnCoursesForThatStudent() {
        //given:
        String name = "student1";
        when(studentService.findStudentByName(name)).thenReturn(mockedStudents());

        //when:
        List<Course> courses = filterService.findCourseByStudentName(name);

        //then:
        assertThat(courses, equalTo(expectedCoursesForStudent()));
    }

    private List<Student> mockedStudents() {
        List<Course> courses = Arrays.asList(
                new Course(1L, "Course 1", Collections.emptyList()));
        return Arrays.asList(new Student(1L, "student1", courses));
    }

    private List<Course> expectedCoursesForStudent() {
        return Arrays.asList(
                new Course(1L, "Course 1", Collections.emptyList()));
    }

    private List<Course> expectedCourses() {
        List<Student> students = Arrays.asList(new Student(1L, "student1", Collections.emptyList()));
        return Arrays.asList(new Course(1L, "course1", students));
    }

    private List<Student> expectedStudentsWithCourse() {
        return Arrays.asList(
                new Student(1L, "student1", Collections.emptyList()));
    }

}
