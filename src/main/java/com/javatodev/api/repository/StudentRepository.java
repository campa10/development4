package com.javatodev.api.repository;

import com.javatodev.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByStudentName(String name);

    List<Student> findStudentByIdNotIn(List<Long> ids);
}
