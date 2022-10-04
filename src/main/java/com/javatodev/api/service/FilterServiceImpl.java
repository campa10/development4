package com.javatodev.api.service;

import com.javatodev.api.model.Course;
import com.javatodev.api.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final CourseService courseService;
    private final StudentService studentService;
    private final EnrollmentService enrollmentService;

    @Override
    public List<Student> findStudentByCourseName(String name) {
        List<Course> courses = courseService.findCourseByName(name);
        return courses.stream().findFirst().map(Course::getStudents).orElse(Collections.emptyList());
    }

    @Override
    public List<Student> findAllStudentsWithoutAnyCourses() {
        List<Long> ids = enrollmentService.findStudentsIds();
        return studentService.findStudentByIdNotIn(ids);
    }

    @Override
    public List<Course> findAllCoursesWithOutAnyStudent() {
        List<Long> ids = enrollmentService.findCoursesIds();
        return courseService.findCourseByIdNotIn(ids);
    }

    @Override
    public List<Course> findCourseByStudentName(String name) {
        List<Student> students = studentService.findStudentByName(name);
        return students.stream().findFirst().map(Student::getCourses).orElse(Collections.emptyList());
    }
}
