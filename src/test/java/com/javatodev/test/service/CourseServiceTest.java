package com.javatodev.test.service;

import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.model.Course;
import com.javatodev.api.repository.CourseRepository;
import com.javatodev.api.service.CourseService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseServiceTest {

    private static CourseService courseService;
    private static final CourseRepository courseRepository = mock(CourseRepository.class);

    @BeforeAll
    static void setUp() {
        courseService = new CourseService(courseRepository);
    }

    @Test
    void createCourseShouldReturnANewCourse() throws Exception {
        //given:
        Course course = new Course(null, "Course 1");
        when(courseRepository.save(course)).thenReturn(expectedCourse());

        //when:
        Course courseSaved = courseService.createOrUpdateCourse(course);

        //then:
        assertThat(courseSaved, equalTo(expectedCourse()));
    }

    @Test
    void updateCourseShouldReturnAnUpdatedCourse() throws RecordNotFoundException {
        //given:
        Course course = new Course(1L, "Course 1");
        when(courseRepository.save(course)).thenReturn(expectedCourse());

        //when:
        Course courseUpdated = courseService.createOrUpdateCourse(course);

        //then:
        assertThat(courseUpdated, equalTo(expectedCourse()));
    }

    @Test
    void createOrUpdateCourseShouldReturnNotFoundException() {
        //given:
        Course course = new Course(null, null);
        when(courseRepository.save(course)).thenThrow(IllegalArgumentException.class);

        //when:
        Executable executable = () -> courseService.createOrUpdateCourse(course);

        //then:
        assertThrows(RecordNotFoundException.class, executable, "No record exist for given id");
    }

    @Test
    void findCourseByIdShouldReturnCourse() throws RecordNotFoundException {
        Long courseId = 1L;
        when(courseRepository.findById(any())).thenReturn(mockedOptionalCourse());

        //when:
        Course course = courseService.findById(courseId);

        //then:
        assertEquals(course, expectedCourse());
    }

    @Test
    void findCoursesByIdShouldReturnRecordNotFoundException() {
        //given:
        Long courseId = 1L;
        when(courseRepository.findById(any())).thenReturn(Optional.empty());

        //when:
        Executable exec = () -> courseService.findById(courseId);

        //then:
        assertThrows(RecordNotFoundException.class, exec, "No record exist for given id");
    }

    @Test
    void findAllCoursesShouldReturnAListOfCourses() {
        //given:
        when(courseRepository.findAll()).thenReturn(expectedCourses());

        //when:
        List<Course> courses = courseService.findCourses();

        //then:
        assertThat(courses, equalTo(expectedCourses()));
    }

    @Test
    void findAllCoursesShouldReturnAnEmptyListOfCourses() {
        //given:
        when(courseRepository.findAll()).thenReturn(Collections.emptyList());

        //when:
        List<Course> courses = courseService.findCourses();

        //then:
        assertTrue(courses.isEmpty());
    }

    @Test
    void deleteCourseShouldReturnRecordNotFoundException() {
        //given:
        Long courseId = null;
        doThrow(IllegalArgumentException.class).when(courseRepository).deleteById(courseId);

        //when:
        Executable executable = () -> courseService.deleteById(courseId);

        //then:
        assertThrows(RecordNotFoundException.class, executable, "No record exist for given id");
    }

    @Test
    void deleteCourseByIdShouldNotThrowException() throws RecordNotFoundException {
        //given:
        Long courseId = 1L;
        doNothing().when(courseRepository).deleteById(courseId);

        //when:
        courseService.deleteById(courseId);

        //then:
        verify(courseRepository).deleteById(courseId);
    }

    private List<Course> expectedCourses() {
        return Arrays.asList(
                new Course(1L, "Course 1"),
                new Course(2L, "Course 2"),
                new Course(3L, "Course 3"),
                new Course(4L, "Course 4"));
    }

    private Course expectedCourse() {
        return new Course(1L, "Course 1");
    }

    private Optional<Course> mockedOptionalCourse() {
        return Optional.of(new Course(1L, "Course 1"));
    }

}