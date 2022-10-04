package com.javatodev.api.service;

import com.javatodev.api.model.Course;
import com.javatodev.api.model.Student;

import java.util.List;

public interface FilterService {

    List<Course> findCourseByStudentName(String name);

    List<Student> findStudentByCourseName(String name);

    List<Student> findAllStudentsWithoutAnyCourses();

    List<Course> findAllCoursesWithOutAnyStudent();
}
