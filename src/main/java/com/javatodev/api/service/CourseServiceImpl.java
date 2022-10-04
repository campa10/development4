package com.javatodev.api.service;

import com.javatodev.api.exception.CourseAlreadyExistException;
import com.javatodev.api.exception.RecordNotFoundException;
import com.javatodev.api.model.Course;
import com.javatodev.api.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course findById(Long courseId) throws RecordNotFoundException {
        Optional<Course> maybeCourse = courseRepository.findById(courseId);
        return maybeCourse.orElseThrow(() -> new RecordNotFoundException("No record exist for given id"));
    }

    @Override
    public List<Course> findCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course createOrUpdateCourse(Course course) throws CourseAlreadyExistException {
        try {
            return courseRepository.save(course);
        } catch (DataAccessException e) {
            throw new CourseAlreadyExistException("There is already a course with that name.");
        }
    }

    @Override
    public void deleteById(Long courseId) throws RecordNotFoundException {
        try {
            courseRepository.deleteById(courseId);
        } catch (EmptyResultDataAccessException e) {
            throw new RecordNotFoundException("No record exist for given id");
        }
    }

    @Override
    public List<Course> findCourseByName(String name) {
        return courseRepository.findCourseByCourseName(name);
    }

    @Override
    public List<Course> findCourseByIdNotIn(List<Long> ids) {
        return courseRepository.findCourseByIdNotIn(ids);
    }

}
