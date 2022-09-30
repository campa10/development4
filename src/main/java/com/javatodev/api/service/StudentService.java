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

    public Student createOrUpdateCourses(Student entity) throws Exception {

        Student finalEntity = entity;
        if (studentRepository.findAll().stream().filter(c -> c.getCourseId().equals(finalEntity.getCourseId())).count() >= 6) {
            System.out.println("\n" +
                    "---------------------------------------" + "\n" +
                    "THIS COURSE HAS NO MORE SPACE  TOTAL BOOKED: " + studentRepository.findAll().stream().filter(c -> c.getCourseId().equals(finalEntity.getCourseId())).count() +
                    "\n" + "---------------------------------------" + "\n");
            throw new Exception("the course is booked");
        }

        Optional<Student> courses = studentRepository.findById(entity.getId());
        if (courses.isPresent()) {
            Student newEntity = courses.get();
            newEntity.setStudentName(entity.getStudentName());
            newEntity = studentRepository.save(newEntity);
            return newEntity;
        } else {
            entity = studentRepository.save(entity);
            return entity;
        }
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


