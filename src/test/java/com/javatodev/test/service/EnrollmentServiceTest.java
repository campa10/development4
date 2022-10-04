package com.javatodev.test.service;

import com.javatodev.api.exception.CourseEnrolledExceedException;
import com.javatodev.api.model.Course;
import com.javatodev.api.model.Enrollment;
import com.javatodev.api.model.Student;
import com.javatodev.api.repository.EnrollmentRepository;
import com.javatodev.api.service.CourseService;
import com.javatodev.api.service.EnrollmentService;
import com.javatodev.api.service.EnrollmentServiceImpl;
import com.javatodev.api.service.StudentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnrollmentServiceTest {

    private static EnrollmentService enrollmentService;
    private static final StudentService studentService = mock(StudentService.class);
    private static final CourseService courseService = mock(CourseService.class);
    private static final EnrollmentRepository enrollmentRepository = mock(EnrollmentRepository.class);

    @BeforeAll
    static void setUp() {
        enrollmentService = new EnrollmentServiceImpl(studentService, courseService, enrollmentRepository);
    }

    @Test
    void findEnrollmentsShouldReturnAListOfEnrollments() {
        //given:
        when(enrollmentRepository.findAll()).thenReturn(mockedEnrollment());

        //when:
        List<Enrollment> enrollments = enrollmentService.findEnrollments();

        //then:
        assertThat(enrollments, equalTo(mockedEnrollment()));
    }

    @Test
    void findStudentsIdsShouldReturnAListOfIds() {
        //given:
        when(enrollmentRepository.findStudentsIds()).thenReturn(Arrays.asList(1L,2L,3L));

        //when:
        List<Long> ids = enrollmentService.findStudentsIds();

        //then:
        assertThat(ids, equalTo(Arrays.asList(1L,2L,3L)));
    }

    @Test
    void findCoursesIdsShouldReturnAListOfIds() {
        //given:
        when(enrollmentRepository.findCoursesIds()).thenReturn(Arrays.asList(1L,2L,3L));

        //when:
        List<Long> ids = enrollmentService.findCoursesIds();

        //then:
        assertThat(ids, equalTo(Arrays.asList(1L,2L,3L)));
    }

    @Test
    void createOrUpdateEnrollmentShouldReturnANewEnrollment() {
        //given:
        Enrollment enrollment = new Enrollment(null, 1L, 1L);
        when(studentService.findById(enrollment.getStudentId())).thenReturn(mockedStudent());
        when(courseService.findById(enrollment.getCourseId())).thenReturn(mockedCourse());
        when(enrollmentRepository.findByStudentIdAndCourseId(any(), any())).thenReturn(Collections.emptyList());
        when(enrollmentRepository.countEnrollmentByStudentId(any())).thenReturn(4);
        when(enrollmentRepository.countEnrollmentByCourseId(any())).thenReturn(20);
        when(enrollmentRepository.save(enrollment)).thenReturn(expectedEnrollment());

        //when:
        Enrollment enrollmentSaved = enrollmentService.createOrUpdateEnrollment(enrollment);

        //then
        assertThat(enrollmentSaved, equalTo(expectedEnrollment()));
    }

    @Test
    void createEnrollmentShouldReturnACourseCapacityException() {
        //given:
        Enrollment enrollment = new Enrollment(null, 1L, 1L);
        when(studentService.findById(enrollment.getStudentId())).thenReturn(mockedStudent());
        when(courseService.findById(enrollment.getCourseId())).thenReturn(mockedCourse());
        when(enrollmentRepository.findByStudentIdAndCourseId(any(), any())).thenReturn(Collections.emptyList());
        when(enrollmentRepository.countEnrollmentByStudentId(any())).thenReturn(4);
        when(enrollmentRepository.countEnrollmentByCourseId(any())).thenReturn(60);

        //when:
        Executable executable = () -> enrollmentService.createOrUpdateEnrollment(enrollment);

        //then
        assertThrows(CourseEnrolledExceedException.class, executable, "The course is complete");
    }

    @Test
    void createEnrollmentShouldReturnACoursesEnrolledException() {
        //given:
        Enrollment enrollment = new Enrollment(null, 1L, 1L);
        when(studentService.findById(enrollment.getStudentId())).thenReturn(mockedStudent());
        when(courseService.findById(enrollment.getCourseId())).thenReturn(mockedCourse());
        when(enrollmentRepository.findByStudentIdAndCourseId(any(), any())).thenReturn(Collections.emptyList());
        when(enrollmentRepository.countEnrollmentByStudentId(any())).thenReturn(6);

        //when:
        Executable executable = () -> enrollmentService.createOrUpdateEnrollment(enrollment);

        //then
        assertThrows(CourseEnrolledExceedException.class, executable, "The student has exceeded the maximum number of courses in which he can enroll");
    }

    @Test
    void createEnrollmentShouldReturnAlreadySignedUpException() {
        //given:
        Enrollment enrollment = new Enrollment(null, 1L, 1L);
        when(studentService.findById(enrollment.getStudentId())).thenReturn(mockedStudent());
        when(courseService.findById(enrollment.getCourseId())).thenReturn(mockedCourse());
        when(enrollmentRepository.findByStudentIdAndCourseId(any(), any())).thenReturn(mockedEnrollment());

        //when:
        Executable executable = () -> enrollmentService.createOrUpdateEnrollment(enrollment);

        //then
        assertThrows(CourseEnrolledExceedException.class, executable, "The student is already enrolled in this course");
    }

    private Course mockedCourse() {
        return new Course(1L, "course1", Collections.emptyList());
    }

    private Student mockedStudent() {
        return new Student(1L, "John", Collections.emptyList());
    }

    private List<Enrollment> mockedEnrollment() {
        return Arrays.asList(new Enrollment(1L, 1L, 1L));
    }

    private Enrollment expectedEnrollment() {
        return new Enrollment(1L, 1L, 1L);
    }

}
