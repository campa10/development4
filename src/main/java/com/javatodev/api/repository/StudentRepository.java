package com.javatodev.api.repository;

import com.javatodev.api.model.Course;
import com.javatodev.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
