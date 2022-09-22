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

    public List<Course> readProducts () {
        return courseRepository.findAll();
    }

    public Course createOrUpdateCourses(Course entity) throws Exception
    {
        Optional<Course> courses = courseRepository.findById(entity.getId());
        if(courses.isPresent()){
            Course newEntity = courses.get();
            newEntity.setCoursename(entity.getCoursename());
            newEntity = courseRepository.save(newEntity);
            return newEntity;
        } else {
            entity = courseRepository.save(entity);
            return entity;
        }
    }

    public void deleteById(Long id) throws RecordNotFoundException
    {
        Optional<Course> employee = courseRepository.findById(id);
        if(employee.isPresent()) {
            courseRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No record exist for given id");
        }
    }

}
