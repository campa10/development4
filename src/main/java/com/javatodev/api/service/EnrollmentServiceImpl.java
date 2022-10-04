package com.javatodev.api.service;

import com.javatodev.api.exception.CourseEnrolledExceedException;
import com.javatodev.api.model.Course;
import com.javatodev.api.model.Enrollment;
import com.javatodev.api.model.Student;
import com.javatodev.api.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.log4j2.Log4J2LoggingSystem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentRepository enrollmentRepository;

    private static final Logger LOG = LoggerFactory.getLogger(Log4J2LoggingSystem.class);

    public Enrollment createOrUpdateEnrollment(Enrollment enrollment) {

        Student student = studentService.findById(enrollment.getStudentId());
        Course course = courseService.findById(enrollment.getCourseId());

        if (alreadySignedUp(student.getId(), course.getId())) {
            LOG.error("CreateOrUpdateEnrollment - The student is already enrolled in this course. StudentId: {}, CourseId: {}", student.getId(), course.getId());
            throw new CourseEnrolledExceedException("The student is already enrolled in this course");
        }

        if (coursesEnrolled(student) >= 5) {
            LOG.error("CreateOrUpdateEnrollment - The student has exceeded the maximum. StudentId: {}, CourseId: {}", student.getId(), course.getId());
            throw new CourseEnrolledExceedException("The student has exceeded the maximum number of courses in which he can enroll");
        }

        if (courseCapacity(course) > 50) {
            LOG.error("CreateOrUpdateEnrollment - The course is complete. StudentId: {}, CourseId: {}", student.getId(), course.getId());
            throw new CourseEnrolledExceedException("The course is complete");
        }

        return enrollmentRepository.save(enrollment);

    }

    @Override
    public List<Enrollment> findEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public List<Long> findStudentsIds() {
        return enrollmentRepository.findStudentsIds();
    }

    @Override
    public List<Long> findCoursesIds() {
        return enrollmentRepository.findCoursesIds();
    }

    private boolean alreadySignedUp(Long studentId, Long courseId) {
        List<Enrollment> enrollmentList = enrollmentRepository.findByStudentIdAndCourseId(studentId, courseId);
        return !enrollmentList.isEmpty();
    }

    private int coursesEnrolled(Student student) {
        return enrollmentRepository.countEnrollmentByStudentId(student.getId());
    }

    private int courseCapacity(Course course) {
        return enrollmentRepository.countEnrollmentByCourseId(course.getId());
    }

}
