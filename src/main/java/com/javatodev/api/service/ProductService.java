package com.javatodev.api.service;

import com.javatodev.api.model.Course;
import com.javatodev.api.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CourseRepository productRepository;

    public List<Course> readProducts () {
        return productRepository.findAll();
    }

}
