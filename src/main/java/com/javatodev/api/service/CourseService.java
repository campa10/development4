package com.javatodev.api.service;

import com.javatodev.api.model.Course;

import java.util.List;

public interface CourseService {

    Course findById(Long courseId);

    List<Course> findCourses();

    Course createOrUpdateCourse(Course course);

    void deleteById(Long courseId);

    List<Course> findCourseByName(String name);

    List<Course> findCourseByIdNotIn(List<Long> ids);

}
