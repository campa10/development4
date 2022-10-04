package com.javatodev.api.repository;

import com.javatodev.api.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudentIdAndCourseId(Long studentId, Long courseId);

    int countEnrollmentByStudentId(Long studentId);

    int countEnrollmentByCourseId(Long courseId);

    @Query("SELECT studentId FROM Enrollment")
    List<Long> findStudentsIds();

    @Query("SELECT courseId FROM Enrollment")
    List<Long> findCoursesIds();
}