package com.javatodev.api.service;

import com.javatodev.api.model.Enrollment;

import java.util.List;

public interface EnrollmentService {

    Enrollment createOrUpdateEnrollment(Enrollment entity);

    List<Enrollment> findEnrollments();

    List<Long> findStudentsIds();

    List<Long> findCoursesIds();

    void deleteByStudentName(String studentName);
}
