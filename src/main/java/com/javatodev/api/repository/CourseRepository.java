package com.javatodev.api.repository;

import com.javatodev.api.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCourseByCourseName(String name);

    List<Course> findCourseByIdNotIn(List<Long> ids);

}
