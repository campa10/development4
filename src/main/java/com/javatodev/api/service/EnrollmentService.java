package com.javatodev.api.service;

import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.model.Enrollment;
import com.javatodev.api.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    
    @Autowired
    private final EnrollmentRepository enrollmentRepository;

    public List<Enrollment> readStudents () {
        return enrollmentRepository.findAll();
    }

    public List<Enrollment> getAll () {
        return enrollmentRepository.getAll();
    }

    public Enrollment createOrUpdateStudents(Enrollment entity) throws RecordNotFoundException
    {
        Optional<Enrollment> employee = enrollmentRepository.findById(entity.getId());
        if(employee.isPresent()){
            Enrollment newEntity = employee.get();
            newEntity.setStudentname(entity.getStudentname());
            newEntity = enrollmentRepository.save(newEntity);
            return newEntity;
        } else {
            entity = enrollmentRepository.save(entity);
            return entity;
        }
    }

}
