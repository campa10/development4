package com.javatodev.api.service;

import com.javatodev.api.model.Course;
import com.javatodev.api.model.Student;
import com.javatodev.api.repository.CourseRepository;
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

    public List<Student> readProducts() {
        return studentRepository.findAll();
    }

    public Student createOrUpdateCourses(Student entity) throws Exception {

        Student finalEntity = entity;
        if (studentRepository.findAll().stream().filter(c -> c.getCourseid().equals(finalEntity.getCourseid())).count() >= 6) {
            System.out.println("\n" +
                    "---------------------------------------" + "\n" +
                    "THIS COURSE HAS NO MORE SPACE  TOTAL BOOKED: " + studentRepository.findAll().stream().filter(c -> c.getCourseid().equals(finalEntity.getCourseid())).count() +
                    "\n" + "---------------------------------------" + "\n");
            throw new Exception("the course is booked");
        }

        Optional<Student> courses = studentRepository.findById(entity.getId());
        if (courses.isPresent()) {
            Student newEntity = courses.get();
            newEntity.setStudentname(entity.getStudentname());
            newEntity = studentRepository.save(newEntity);
            return newEntity;
        } else {
            entity = studentRepository.save(entity);
            return entity;
        }
    }
}


