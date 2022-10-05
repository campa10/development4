package com.javatodev.api.service;

import com.javatodev.api.exception.EnrolledException;
import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.exception.StudentAlreadyExistException;
import com.javatodev.api.model.Student;
import com.javatodev.api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> findStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long studentId) throws RecordNotFoundException {
        Optional<Student> maybeStudent = studentRepository.findById(studentId);
        return maybeStudent.orElseThrow(() -> new RecordNotFoundException("No record exist for given id"));
    }

    @Override
    public Student createOrUpdateStudent(Student entity) throws StudentAlreadyExistException {
        try {
            return studentRepository.save(entity);
        } catch (DataAccessException e) {
            throw new StudentAlreadyExistException("There is already a student with that name.");
        }
    }

    @Override
    public void deleteById(Long studentId) throws RecordNotFoundException {
        try {
            studentRepository.deleteById(studentId);
        } catch (EmptyResultDataAccessException e) {
            throw new RecordNotFoundException("No record exist for given id");
        } catch (Exception e) {
            throw new EnrolledException("This student cannot be deleted, it must not have course enrolled.");
        }

    }

    @Override
    public List<Student> findStudentByName(String name) {
        return studentRepository.findStudentByStudentName(name);
    }

    @Override
    public List<Student> findStudentByIdNotIn(List<Long> ids) {
        return studentRepository.findStudentByIdNotIn(ids);
    }

}


