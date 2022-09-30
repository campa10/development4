package com.javatodev.api.service;

import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.model.Student;
import com.javatodev.api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public List<Student> findStudents() {
        return studentRepository.findAll();
    }

    public Student createOrUpdateStudent(Student entity) throws RecordNotFoundException {
        try {
            return studentRepository.save(entity);
        } catch (Exception e) {
            throw new RecordNotFoundException("No record exist for given id");
        }
    }

    public Student findById(Long studentId) throws RecordNotFoundException {
        Optional<Student> maybeStudent = studentRepository.findById(studentId);
        return maybeStudent.orElseThrow(() -> new RecordNotFoundException("No record exist for given id"));
    }

    public void deleteById(Long studentId) throws RecordNotFoundException {
        try {
            studentRepository.deleteById(studentId);
        } catch (Exception e) {
            throw new RecordNotFoundException("No record exist for given id");
        }
    }
}


