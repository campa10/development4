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
    private final StudentRepository StudentRepository;

    public List<Student> readStudents () {
        return StudentRepository.findAll();
    }

    public Student createOrUpdateStudents(Student entity) throws RecordNotFoundException
    {
        Optional<Student> employee = StudentRepository.findById(entity.getId());
        if(employee.isPresent()){
            Student newEntity = employee.get();
            newEntity.setStudentname(entity.getStudentname());
            newEntity = StudentRepository.save(newEntity);
            return newEntity;
        } else {
            entity = StudentRepository.save(entity);
            return entity;
        }
    }

}
