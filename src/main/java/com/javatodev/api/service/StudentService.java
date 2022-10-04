package com.javatodev.api.service;

import com.javatodev.api.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findStudents();

    Student findById(Long studentId);

    Student createOrUpdateStudent(Student entity);

    void deleteById(Long studentId);

    List<Student> findStudentByName(String name);

    List<Student> findStudentByIdNotIn(List<Long> ids);

}
