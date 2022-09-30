package com.javatodev.api.repository;

import com.javatodev.api.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("FROM Course")
    List<Course> findByStudentName(String studentName);

    @Query("FROM Course")
    List<Course> findAllCoursesWithoutAnyStudents();
}
