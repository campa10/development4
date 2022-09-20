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
            System.out.println("Sorry but the max of students is: " + courseRepository.findAll().stream().count());
            if(courseRepository.findAll().stream().count() <= 6){
                throw new Exception("This course can not accept any more enrollments");
            }
            Course newEntity = courses.get();
            newEntity.setCoursename(entity.getCoursename());
            newEntity = courseRepository.save(newEntity);
            return newEntity;
        } else {
            entity = courseRepository.save(entity);
            return entity;
        }
    }

}
