package com.javatodev.api.service;

import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.model.Course;
import com.javatodev.api.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    public List<Course> readProducts() {
        return courseRepository.findAll();
    }

    public Course createOrUpdateCourses(Course entity) throws Exception {
        Optional<Course> courses = courseRepository.findById(entity.getId());
        if (courses.isPresent()) {
            Course newEntity = courses.get();
            newEntity.setCourseName(entity.getCourseName());
            newEntity = courseRepository.save(newEntity);
            return newEntity;
        } else {
            entity = courseRepository.save(entity);
            return entity;
        }
    }

    public Course findById(Long courseId) throws RecordNotFoundException {
        Optional<Course> maybeCourse = courseRepository.findById(courseId);
        return maybeCourse.orElseThrow(() -> new RecordNotFoundException("No record exist for given id"));
    }

    public List<Course> findCourses() {
        return courseRepository.findAll();
    }

    public Course createOrUpdateCourse(Course course) throws RecordNotFoundException {
        try {
            return courseRepository.save(course);
        } catch (Exception e) {
            throw new RecordNotFoundException("No record exist for given id");
        }
    }

    public void deleteById(Long courseId) throws RecordNotFoundException {
        try {
            courseRepository.deleteById(courseId);
        } catch (Exception e) {
            throw new RecordNotFoundException("No record exist for given id");
        }
    }
}
